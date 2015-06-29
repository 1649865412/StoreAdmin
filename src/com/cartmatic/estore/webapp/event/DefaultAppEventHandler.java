/**
 * 
 */

package com.cartmatic.estore.webapp.event;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.cartmatic.estore.common.helper.ConfigUtil;
import com.cartmatic.estore.core.event.AppEventHandler;
import com.cartmatic.estore.core.event.ApplicationEvent;
import com.cartmatic.estore.core.event.ConfigChangedEvent;
import com.cartmatic.estore.core.event.ConfigChangedEventListener;
import com.cartmatic.estore.core.event.RefreshContextEvent;
import com.cartmatic.estore.core.filter.CacheFilter;
import com.cartmatic.estore.core.util.AppContextLoader;
import com.cartmatic.estore.core.util.ContextUtil;
import com.cartmatic.estore.sales.engine.PRuleManager;


/**
 *  系统初始化配置，转给各事件的具体处理方法来处理
 *  <code>DefaultAppEventHandler.java</code>
 *  <p>
 *  <p>Copyright  2015 All right reserved.
 *  @author admin 时间 2015-6-29 下午05:09:51	
 *  @version 1.0 
 *  </br>最后修改人 无
 */
public class DefaultAppEventHandler implements AppEventHandler {
	private static final Log logger	= LogFactory.getLog(DefaultAppEventHandler.class);

	// 用来取得springMvc的controller的context
	private String mvcContextName = FrameworkServlet.SERVLET_CONTEXT_PREFIX + "springMvc";


	/**  系统相关配置初始化处理
	 *   转给各事件的具体处理方法来处理
	 * 
	 * @param event
	 */
	public void handleApplicationEvent(ApplicationEvent event) {
		logger.info("Processing application event: " + event);
		System.out.println("Processing application event: " + event);;
		if (event instanceof ConfigChangedEvent) {
			//更新系统配置缓存先，对于不存储起来的系统配置，通过下面代码立刻生效；因此系统配置不再需要使用缓存
			handleConfigChangedEvent((ConfigChangedEvent) event);
		} else if (event instanceof RefreshContextEvent) {
			//功能:系统业务功能初始货配置，包括货币，系统设置，支付配置等
			handleRefreshContextEvent((RefreshContextEvent) event);
		}else if(event instanceof RefreshPromoEvent){
			//这是管理更新系统中的促销规则的类,方便ruleEngine获取规则数据，不需要每次都从数据库中读取，若在页面更新规则也必须通知该类。
			handleRefreshPromoEvent((RefreshPromoEvent) event);
		}
		logger.info("Done processing application event: " + event);
	}

	
	/**
	 * 功能这是管理更新系统中的促销规则的类,方便ruleEngine获取规则数据，不需要每次都从数据库中读取，若在页面更新规则也必须通知该类。:
	 * <p>作者 杨荣忠 2015-6-29 下午05:08:52
	 * @param event
	 */
	private void handleRefreshPromoEvent(RefreshPromoEvent event) {
		PRuleManager pruleManager = (PRuleManager) ContextUtil.getSpringBeanById("pruleManager");
		pruleManager.refresh();
		
	}

	
	/**
	 * 功能:更新系统配置缓存先，对于不存储起来的系统配置，通过下面代码立刻生效；因此系统配置不再需要使用缓存
	 * <p>作者 杨荣忠 2015-6-29 下午05:06:13
	 * @param event
	 */
	private void handleConfigChangedEvent(ConfigChangedEvent event) 
	{
		// 更新系统配置缓存先，对于不存储起来的系统配置，通过下面代码立刻生效；因此系统配置不再需要使用缓存
		//ConfigUtil.getInstance().onConfigChanged(event.getConfigKey(), event.getNewConfigValue());
		AppContextLoader appContextLoader = (AppContextLoader) ContextUtil.getInstance().getSpringBeanById("appContextLoader");
		appContextLoader.reloadConfig();
		// 处理储存起来的（不是每次都从ConfigUtil读）的系统配置
		ServletContext servletContext = ContextUtil.getServletContext();
		if ("BrowserSidePageCacheSeconds".equals(event.getConfigKey())) 
		{
			ApplicationContext controllerCtx = (ApplicationContext) servletContext.getAttribute(mvcContextName);

			// 令所有MultiActionController的子类（因为一般来说FormController不需要缓存）更新缓存设置
			Map beans = controllerCtx.getBeansOfType(MultiActionController.class);
			Iterator iter = beans.values().iterator();
			while (iter.hasNext()) 
			{
				Object bean = iter.next();
				if (bean instanceof ConfigChangedEventListener)
				{
					((ConfigChangedEventListener) bean).onConfigChanged(event);
				}
			}
		}

		if ("BrowserSidePageCacheSeconds".equals(event.getConfigKey())
				|| "ServerSidePageCacheSeconds".equals(event.getConfigKey())
				|| "CachableUrls".equals(event.getConfigKey())
				|| "IsServerSideProductPageCacheEnabled".equals(event.getConfigKey()))
		{
			// 更新CacheFilter的缓存设置
			CacheFilter cacheFilter = (CacheFilter) ContextUtil.getSpringBeanById("cacheFilterBean");
			if (cacheFilter != null) 
			{
				cacheFilter.onConfigChanged();
			}
		}
		// 如果还有其他bean/filter不能自动更新的，在下面处理

	}

	
	/**
	 * 功能:系统业务功能初始货配置，包括货币，系统设置，支付配置等
	 * <p>作者 杨荣忠 2015-6-29 下午05:06:58
	 * @param event
	 */
	private void handleRefreshContextEvent(RefreshContextEvent event) {
		if (RefreshContextEvent.CATEGORY_SERVER_SIDE_CACHE.equals(event.getRefreshCategory())) 
		{
			AppContextLoader appContextLoader = (AppContextLoader) ContextUtil.getInstance().getSpringBeanById("appContextLoader");
			appContextLoader.clearAllServerSideCaches();
			appContextLoader.reloadCurrency();
			appContextLoader.reloadConfig();

		}
//		if (RefreshContextEvent.CATEGORY_MENU
//				.equals(event.getRefreshCategory())) {
//			ContextUtil.getInstance().reloadMenu();
//		}
	}

	/**
	 * @param appEventManager
	 *            the appEventManager to set
	 */
	/*public void setAppEventManager(AppEventManager appEventManager) {
		this.appEventManager = appEventManager;
	}*/

//	public void setAppContextLoader(AppContextLoader avalue)
//	{
//		this.appContextLoader = avalue;
//	}
}
