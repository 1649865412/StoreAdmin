package com.cartmatic.estoresa.catalog.web.action;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

import com.cartmatic.estore.branddynamic.service.BrandDynamicManager;
import com.cartmatic.estore.catalog.service.BrandManager;
import com.cartmatic.estore.catalog.service.ProductManager;
import com.cartmatic.estore.common.model.branddynamic.BrandDynamic;
import com.cartmatic.estore.common.model.catalog.Brand;
import com.cartmatic.estore.common.model.catalog.BrandDynamicModel;
import com.cartmatic.estore.common.model.catalog.Product;
import com.cartmatic.estore.common.model.culturalinformation.CulturalInformation;
import com.cartmatic.estore.core.controller.GenericController;
import com.cartmatic.estore.core.exception.ApplicationException;
import com.cartmatic.estore.core.model.BaseObject;
import com.cartmatic.estore.core.model.Message;
import com.cartmatic.estore.core.view.AjaxView;
import com.cartmatic.estore.culturalinformation.service.CulturalInformationManager;
import com.cartmatic.estore.culturalinformation.util.CalenderTime;

public class BrandController extends GenericController<Brand>
{

	private BrandManager brandManager = null;

	private CulturalInformationManager culturalInformationManager = null;

	private BrandDynamicManager brandDynamicManager = null;

	private ProductManager productManager = null;

	public void setBrandDynamicManager(BrandDynamicManager brandDynamicManager) {
		this.brandDynamicManager = brandDynamicManager;
	}

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

	public void setBrandManager(BrandManager inMgr) {
		this.brandManager = inMgr;
	}

	public CulturalInformationManager getCulturalInformationManager() {
		return culturalInformationManager;
	}

	public void setCulturalInformationManager(CulturalInformationManager culturalInformationManager) {
		this.culturalInformationManager = culturalInformationManager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cartmatic.estore.core.controller.GenericController#getEntityName(
	 * java.lang.Object)
	 */
	@Override
	protected String getEntityName(Brand entity) {
		return entity.getBrandName();
	}

	/**
	 * 构造批量更新所需的model。
	 * <P>
	 * 本来这方法对大部分情况也是可以自动分析和转换的，但考虑到比较复杂和难以灵活（验证、缺省值、I18N等、Status转换等），暂时要求各模块自己实现
	 * 。要求数据要先转换为正确的类型。
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected Map<Integer, Map<String, Object>> getMultiSaveModel(HttpServletRequest request) {
		// FIXME
		throw new RuntimeException("Not implemented yet!");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.controller.BaseController#initController()
	 */
	@Override
	protected void initController() throws Exception {
		mgr = brandManager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cartmatic.estore.core.controller.GenericController#onSave(javax.servlet
	 * .http.HttpServletRequest, java.lang.Object,
	 * org.springframework.validation.BindException)
	 */
	@Override
	protected void onSave(HttpServletRequest request, Brand entity, BindException errors) {
		Brand tempBrand = brandManager.getBrandByCode(entity.getBrandCode());
		if (tempBrand != null && (entity.getBrandId() == null || (entity.getBrandId().intValue() != tempBrand.getBrandId().intValue())))
		{
			String msgKey = "brand.brandCode.repeated";
			errors.rejectValue("brandCode", msgKey);
		}
	}

	/**
	 * 重写保存
	 */
	@Override
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 取得Form对应的Model
		Brand entity = formBackingObject(request);
		BindException errors = null;
		try
		{
			ServletRequestDataBinder binder = bindAndValidate(request, entity);
			errors = new BindException(binder.getBindingResult());
			onSave(request, entity, errors);
			// 传给子类的实现，后者可以继续验证和加入错误到errors
			if (!errors.hasErrors())
			{// 里面如果出错应该抛出异常
				mgr.save(entity);
				BrandDynamicModel brandDynamicModel = new BrandDynamicModel();
				brandDynamicModel.setImgArray(request.getParameterValues("imgArray"));
				brandDynamicModel.setCharacterArray(request.getParameterValues("characterArray"));
				brandDynamicModel.setDateTimeArray(request.getParameterValues("dateTimeArray"));
				brandDynamicModel.setResourceArray(request.getParameterValues("resourceArray"));
				brandDynamicModel.setWebsiteArray(request.getParameterValues("websiteArray"));
				brandDynamicModel.setBrandDynamicIdArray(request.getParameterValues("brandDynamicIdArray"));
				saveMonth(brandDynamicModel, entity);
				String msgKey = (isEntityNew(request)) ? "common.added" : "common.updated";
				saveMessage(Message.info(msgKey, new Object[] { getEntityTypeMessage(), getEntityName(entity) }));
			}
		}
		catch (ApplicationException e)
		{
			handleApplicationException(errors, e);
		}

		ModelAndView mav;
		if (errors.hasErrors())
		{
			mav = showForm(request, errors);
		}
		else if (successView != null)
		{
			mav = getModelAndView(successView, errors.getModel());
		}
		else
		{
			mav = getRedirectToActionView("edit", ((BaseObject) entity).getId().toString());
		}
		return mav;
	}

	
	/**
	 * 功能:保存设计师动态数据
	 * <p>
	 * 作者 杨荣忠 2015-7-7 下午02:05:04
	 * 
	 * @param mediaUrls_d
	 * @param culturalInformation
	 * @throws ParseException
	 */
	public void saveMonth(BrandDynamicModel brandDynamicModel, Brand entity) throws ParseException {
		if(addOrEdit(brandDynamicModel))
		{
			if (brandDynamicModel != null&&brandDynamicModel.getImgArray()!=null)
			{
				String array[] =brandDynamicModel.getImgArray() ;
				int num = array.length;
				for (int i = 0; i < num; i++)
				{
					BrandDynamic brandDynamic = new BrandDynamic();
					brandDynamic.setImg(brandDynamicModel.getImgArray()[i]);
					brandDynamic.setContent(brandDynamicModel.getCharacterArray()[i]);
					brandDynamic.setResource(brandDynamicModel.getResourceArray()[i]);
					brandDynamic.setWebsite(brandDynamicModel.getWebsiteArray()[i]);
					brandDynamic.setResourceTime(brandDynamicModel.getDateTimeArray()[i]);
					brandDynamic.setBrandId(entity.getBrandId());
					brandDynamic.setCreateTime(CalenderTime.strtodate(CalenderTime.getToday("yyyy-MM-dd"), "yyyy-MM-dd"));
					brandDynamicManager.merge(brandDynamic);
				}
			}
		}else{
			String brandDynamicIdArray[] =brandDynamicModel.getBrandDynamicIdArray();
			for(int i=0;i<brandDynamicIdArray.length;i++)
			{
				BrandDynamic brandDynamic =brandDynamicManager.getById(Integer.parseInt(brandDynamicIdArray[i]));
				brandDynamic.setContent(brandDynamicModel.getCharacterArray()[i]);
				brandDynamic.setResource(brandDynamicModel.getResourceArray()[i]);
				brandDynamic.setWebsite(brandDynamicModel.getWebsiteArray()[i]);
				brandDynamic.setResourceTime(brandDynamicModel.getDateTimeArray()[i]);
				brandDynamic.setCreateTime(CalenderTime.strtodate(CalenderTime.getToday("yyyy-MM-dd"), "yyyy-MM-dd"));
				brandDynamicManager.merge(brandDynamic);
			}
		}
	}

	
	/**
	 * 功能:判断动态资讯增加是增加还是更新
	 * 返回true是add ,否则是编辑
	 * <p>作者 杨荣忠 2015-7-10 下午01:32:09
	 * @param brandDynamicModel
	 * @return
	 */
	public boolean addOrEdit(BrandDynamicModel brandDynamicModel){
		boolean flag = true;
		//String brandDynamicIdArray =.toString();
	/*	System.out.print("value:"+Arrays.toString(brandDynamicModel.getBrandDynamicIdArray());
		if(brandDynamicIdArray.trim().equals("")){
			flag = true;
		}*/
		return flag;
	}
	
	
	/**
	 * 功能:动态进入后台删 除设计师数据 返回结果 默认情况下 1表示成功 0表示失败
	 * <p>
	 * 作者 杨荣忠 2015-5-18 下午02:19:58
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView deleteBrandDynamic(HttpServletRequest request, HttpServletResponse response) {
		boolean flag = false;
		try
		{
			int brandId = Integer.parseInt(request.getParameter("brandId"));
			BrandDynamic brandDynamic = brandDynamicManager.deleteById(brandId);
			AjaxView ajaxView = new AjaxView(response);
			flag = true;
		}
		catch (Exception e)
		{
			flag = false;
		}
		AjaxView ajaxView = new AjaxView(response);
		if (flag == true)
		{
			ajaxView.setStatus((short) 1);
		}
		else
		{
			ajaxView.setStatus((short) 0);
		}
		return ajaxView;
	}

	/**
	 * showFrom时调用,可以重载这个方法在mv上加入一些新的元素，补充重写进入表单的方法,例如编辑， 主要获取推荐资讯的数据还有该文化资讯的月刊
	 * 
	 * @param request
	 * @param mv
	 */
	protected void onShowForm(HttpServletRequest request, ModelAndView mv) {
		// System.out.print("进入编辑最后阶段！");
		Brand brand = formBackingObject(request);
		try
		{
			List<CulturalInformation> CulturalInformationList = culturalInformationManager.getAllByIdArray(brand.getCulturalRecommendId());
			mv.addObject("reCulturalInformationList", CulturalInformationList);
			List<Product> ProductList = productManager.getAllByIdArray(brand.getProductRecommendId());
			mv.addObject("reProductList", ProductList);
			List<BrandDynamic> brandDynamicList = new ArrayList(brand.getBrandDynamics());
			mv.addObject("brandDynamicList", brandDynamicList);
		}
		catch (Exception e)
		{
			System.out.println("进入文化资讯onShowForm方法有误");
		}
	}

	/**
	 * 功能:异步获取品牌
	 * <p>
	 * 作者 杨荣忠 2015-7-9 上午11:46:58
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ModelAndView getBrands(HttpServletRequest request, HttpServletResponse response) throws IOException {
		AjaxView ajaxView = new AjaxView(response);
		List<Brand> brandList = brandManager.getAllOrdered("brandName", true);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] { "sortOrder", "website", "logo", "version", "products", "firstKeyColumnName", "id",
				"integerId" });
		JSON brandJsonList = JSONSerializer.toJSON(brandList, jsonConfig);
		ajaxView.setData(brandJsonList);
		return ajaxView;
	}
}
