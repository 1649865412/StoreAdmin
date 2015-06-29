/*
 * create by ycm on 2006-05-19
 */

package com.cartmatic.estore.webapp.util;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cartmatic.estore.Constants;
import com.cartmatic.estore.common.model.cart.Shoppingcart;
import com.cartmatic.estore.common.model.order.SalesOrder;

/**
 *  
 *  <code>web项目session处理类</code>
 *  <p>
 *  <p>Copyright  2015 All right reserved.
 *  @author admin 时间 2015-6-29 上午11:15:25	
 *  @version 1.0 
 *  </br>最后修改人 无
 */
public class SessionUtil {
	public final static String	BOOL_FROMCHECKOUT	= "fromCheckout";

	/**
	 * all attributes save in session must be set a constant String in here the
	 * constant format is [Type]_[Name]
	 */

	protected final static Log	logger	= LogFactory.getLog(SessionUtil.class);
	public final static String	OBJ_CHECKOUTMODEL	= "checkoutModel";
	public final static String	OBJ_MINICART		= "minicart";
	public final static String	OBJ_SHOPPINGCART	= "shoppingcart";

	
	
	/**
	 * 功能:session值获取
	 * <p>作者 杨荣忠 2015-6-29 上午11:14:51
	 * @param _session
	 * @param sKey
	 * @return
	 */
	private static Object getAttribute(HttpSession _session, String sKey) {
		if (_session == null) {
			return null;
		}
		return _session.getAttribute(sKey);
	}

	
	/**
	 * 功能:session 设置(Key-Value)
	 * <p>作者 杨荣忠 2015-6-29 上午11:12:45
	 * @param _session
	 * @param sKey
	 * @param obj
	 */
	public static void setAttribute(HttpSession _session, String sKey,
			Object obj) {
		if (_session != null) {
			_session.setAttribute(sKey, obj);
		}
	}

    /**
     * 功能::session 设置(currentGroupKey-Value)
     * <p>作者 杨荣忠 2015-6-29 上午11:14:12
     * @param session
     * @param currentGroupKey
     */
	public static void setCurrentGroupKey(HttpSession session,
			String currentGroupKey) {
		session.setAttribute(Constants.CURRENT_GROUP_KEY, currentGroupKey);
	}

	public static void setNewProductId(HttpSession _session, Set newProductIds) {
//		SessionUtil.setAttribute(_session,
//				Constants.Shoppingcart_NEW_PRODUCT_IDS, newProductIds);
	}


	public static void setShoppingcart(HttpSession _session,
			Shoppingcart shoppingcart) {
		SessionUtil.setAttribute(_session, SessionUtil.OBJ_SHOPPINGCART,
				shoppingcart);
	}

	private SessionUtil() {
	}

}
