package com.cartmatic.estore.cart.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cartmatic.estore.cart.CheckoutConstants;
import com.cartmatic.estore.cart.dao.ShoppingcartDao;
import com.cartmatic.estore.common.helper.ConfigUtil;
import com.cartmatic.estore.common.model.cart.Shoppingcart;
import com.cartmatic.estore.common.model.cart.ShoppingcartItem;
import com.cartmatic.estore.common.model.customer.Customer;
import com.cartmatic.estore.common.service.ShoppingcartService;
import com.cartmatic.estore.webapp.util.RequestContext;
import com.cartmatic.estore.webapp.util.RequestUtil;

public class ShoppingCartUtil
{

	public static final String CHECK_NAME_PRODUCT_JUANKONG = "Mipenna限量版 24K包金玫瑰永生花礼盒";

	private final static ShoppingCartUtil shoppingCartUtil = new ShoppingCartUtil();
	private ShoppingcartDao shoppingcartDao;

	private ShoppingcartService shoppingcartService;

	public void setShoppingcartService(ShoppingcartService shoppingcartService) {
		this.shoppingcartService = shoppingcartService;
	}

	public void setShoppingcartDao(ShoppingcartDao shoppingcartDao) {
		this.shoppingcartDao = shoppingcartDao;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 */

	public static synchronized ShoppingCartUtil getInstance() {
		return shoppingCartUtil;
	}

	public void removeShoppingcartCookie(HttpServletRequest request, HttpServletResponse response) {
		RequestUtil.setCookie(response, CheckoutConstants.SHOPPINGCART_COOKIE, "", request.getContextPath());
		RequestUtil.setCookie(response, CheckoutConstants.SHOPPINGCART_PRICE_COOKIE, "0", request.getContextPath());
		RequestUtil.setCookie(response, CheckoutConstants.C_ITEMCOUNT_COOKIE, "0", request.getContextPath());
		RequestUtil.setCookie(response, CheckoutConstants.F_ITEMCOUNT_COOKIE, "0", request.getContextPath());
		RequestUtil.setCookie(response, CheckoutConstants.SHOPPINGCAT_ITEMCOUT_COOKIE, "0", request.getContextPath());
	}

	/**
	 * 判断满减优惠 Mipenna=15 Lapeewee=37 V.Charm=44
	 * 
	 * @param shoppingcart
	 * @return
	 */
	public static double fullCutPrice(Shoppingcart shoppingcart) {
		double result = 0;
		double mipennaPrice = 0;
		double lapeeweePrice = 0;
		double vcharmPrice = 0;
		// 时间控制
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		long time = Long.parseLong(format.format(date));
		long t1 = 20150907000000l;
		long t2 = 20150913235900l;
		long difference1 = time - t1;
		long difference2 = time - t2;
		if (difference1 > 0 && difference2 < 0)
		{
			Set<ShoppingcartItem> items = shoppingcart.getCartItems();
			for (ShoppingcartItem item : items)
			{
				try
				{
					Integer brandId = item.getProductSku().getProduct().getBrandId();
					int quantity = item.getQuantity();
					if (brandId == 39)
					{
						mipennaPrice += (item.getProductSku().getPrice().doubleValue()) * quantity;
					}
				/*	else if (brandId == 37)
					{
						lapeeweePrice += (item.getProductSku().getPrice().doubleValue()) * quantity;
					}
					else if (brandId == 44)
					{
						vcharmPrice += (item.getProductSku().getPrice().doubleValue()) * quantity;
					}*/
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			
			if (mipennaPrice >= 300 )
			{
				//每满300减50
				result +=getResidue(mipennaPrice)*50;
			}
			
			/*else if (mipennaPrice >= 600 && mipennaPrice < 900)
			{
				result += 100;
			}
			else if (mipennaPrice >= 900)
			{
				result += 150;
			}*/
			/*if (lapeeweePrice >= 900 && lapeeweePrice < 1200)
			{
				result += 100;
			}
			else if (lapeeweePrice >= 1200)
			{
				result += 200;
			}
			if (vcharmPrice >= 400 && vcharmPrice < 500)
			{
				result += 100;
			}
			else if (vcharmPrice >= 500 && vcharmPrice < 600)
			{
				result += 150;
			}
			else if (vcharmPrice >= 600 && vcharmPrice < 700)
			{
				result += 200;
			}
			else if (vcharmPrice >= 700 && vcharmPrice < 800)
			{
				result += 250;
			}
			else if (vcharmPrice >= 800)
			{
				result += 300;
			}*/
		}
		return result;
	}
	
	/**
	 * 功能:每满300减50
	 * <p>作者 杨荣忠 2015-9-7 下午04:01:01
	 * @param mipennaPrice
	 * @return
	 */
	public static double getResidue(Double mipennaPrice){
		double value =0;
		//每满300减50
		value = (mipennaPrice-(mipennaPrice%300.0))/300.0;		
		return value;
	}

	// product.productName
	public static int checkHaveJuankong(Shoppingcart shoppingcart) {
		// ${shoppingcart.cartItems}
		int result = 0;
		Set<ShoppingcartItem> items = shoppingcart.getCartItems();
		for (ShoppingcartItem item : items)
		{
			try
			{
				String name = item.getProductSku().getProduct().getProductName();
				if (name.contains(CHECK_NAME_PRODUCT_JUANKONG))
				{
					result = 1;
					break;
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * <h3>获取当前用户的购物车</h3>
	 * <p>
	 * 由于使用了acegi架构，用户登陆后，即使在持久层配置了自动加载购物车，但是依然还是无法得到用户的购物车，即，不能
	 * 使用customer.getShoppingcart()的方法得到购物车。因此，提供此方法来获得当前用户的购物车
	 * </p>
	 * 
	 * @return
	 */
	public Shoppingcart getCurrentUserShoppingcart() {
		Customer customer = (Customer) RequestContext.getCurrentUser();
		return getCurrentUserShoppingcart(customer);
	}

	public Shoppingcart getCurrentUserShoppingcart(Customer customer) {
		Shoppingcart cart = shoppingcartDao.getShoppingcartByCustomer(customer, ConfigUtil.getInstance().getStore());
		return cart;
	}

	/**
	 * 合并购物车信息
	 * 
	 * @param req
	 * @param resp
	 */
	public void setShoppingcartInfo(HttpServletRequest req, HttpServletResponse resp, Customer customer) {
		// Customer customer = (Customer) RequestContext.getCurrentUser();
		Shoppingcart cartDb = ShoppingCartUtil.getInstance().getCurrentUserShoppingcart(customer);
		Cookie cookie = RequestUtil.getCookie(req, CheckoutConstants.SHOPPINGCART_COOKIE);
		String cartCookieUuid = "";
		if (cookie != null)
		{
			cartCookieUuid = cookie.getValue();
		}

		if (cartDb != null)
		{
			if (!cartCookieUuid.equals(""))
			{
				shoppingcartService.doUniteShoppingcarts(cartDb.getUuid(), cartCookieUuid, req, resp);
				shoppingcartService.refreshShoppingcart(cartDb.getUuid(), req, resp);
			}
			else
			{
				shoppingcartService.refreshShoppingcart(cartDb.getUuid(), req, resp);
			}
		}
		else if (!cartCookieUuid.equals(""))
		{
			Shoppingcart cartCookie = shoppingcartService.loadShoppingcartByUuid(cartCookieUuid);
			if (cartCookie != null && cartCookie.getCustomerId() == null)
			{
				cartCookie.setCustomerId(customer.getAppuserId());
				shoppingcartService.refreshShoppingcart(cartCookieUuid, req, resp);
			}
			else if (cartCookie != null && cartCookie.getCustomerId() != null)
			{// cookie中的购物车不是刚刚登陆的此用户
				ShoppingCartUtil.getInstance().removeShoppingcartCookie(req, resp);
			}
		}
		else
		{
			Shoppingcart newCart = shoppingcartService.newShoppingcart(customer);
			shoppingcartService.refreshShoppingcart(newCart.getUuid(), req, resp);
		}
	}

}
