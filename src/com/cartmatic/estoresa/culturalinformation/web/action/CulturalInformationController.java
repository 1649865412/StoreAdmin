
package com.cartmatic.estoresa.culturalinformation.web.action;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cartmatic.estore.common.helper.CatalogHelper;
import com.cartmatic.estore.common.model.culturalinformation.CulturalInformation;
import com.cartmatic.estore.common.model.monthlycultural.MonthlyCultural;
import com.cartmatic.estore.core.controller.GenericController;
import com.cartmatic.estore.core.exception.ApplicationException;
import com.cartmatic.estore.core.model.BaseObject;
import com.cartmatic.estore.core.model.Message;
import com.cartmatic.estore.core.view.AjaxView;
import com.cartmatic.estore.culturalinformation.service.CulturalInformationManager;
import com.cartmatic.estore.culturalinformation.util.CalenderTime;
import com.cartmatic.estore.monthlycultural.service.MonthlyCulturalManager;
import com.cartmatic.estore.textsearch.SearchConstants;
import com.cartmatic.estore.webapp.util.RequestUtil;

public class CulturalInformationController extends GenericController<CulturalInformation> {
	
    private CulturalInformationManager culturalInformationManager = null;
    
    private MonthlyCulturalManager monthlyCulturalManager = null;
    
    public static final int MONTH_TYPE =4;
    
    public void setCulturalInformationManager(CulturalInformationManager inMgr) {
        this.culturalInformationManager = inMgr;
    }

	public void setMonthlyCulturalManager(MonthlyCulturalManager monthlyCulturalManager) {
		this.monthlyCulturalManager = monthlyCulturalManager;
	}

	
	/**
	 * 重写保存
	 */
	@Override
	public ModelAndView save(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 取得Form对应的Model
		CulturalInformation entity = formBackingObject(request);
		BindException errors = null;
		String mediaUrls_d[] =request.getParameterValues("productMedia_urls_d");
		try {
			ServletRequestDataBinder binder = bindAndValidate(request, entity);
			errors = new BindException(binder.getBindingResult());
			// 传给子类的实现，后者可以继续验证和加入错误到errors
			if (!errors.hasErrors()) {// 里面如果出错应该抛出异常
				mgr.save(entity);
			//	System.out.print("id:"+entity.getCulturalInformationId());
				saveMonth( mediaUrls_d,entity);
				String msgKey = (isEntityNew(request)) ? "common.added": "common.updated";
				saveMessage(Message.info(msgKey, new Object[] {getEntityTypeMessage(), getEntityName(entity)}));
			}
		} catch (ApplicationException e) {
			handleApplicationException(errors, e);
		}

		ModelAndView mav;
		if (errors.hasErrors()) {
			mav = showForm(request, errors);
		} else if (successView != null) {
			mav = getModelAndView(successView, errors.getModel());
		} else {
			mav = getRedirectToActionView("edit", ((BaseObject) entity).getId()
					.toString());
		}
		return mav;
	}
	
	  /**
     * 功能:动态进入后台删 除月刊数据
	 * 返回结果
	 * 默认情况下
	 * 1表示成功
	 * 0表示失败
     * <p>作者 杨荣忠 2015-5-18 下午02:19:58
     * @param request
     * @param response
     * @return
     */
	public ModelAndView deleteMonthly(HttpServletRequest request, HttpServletResponse response)
    {
        boolean flag =false;
        try{
        	int monthlyCulturalId = Integer.parseInt(request.getParameter("monthlyCulturalId"));
        	MonthlyCultural monthlyCultural= monthlyCulturalManager.deleteById(monthlyCulturalId);
            AjaxView ajaxView = new AjaxView(response);
            flag =true;
        }catch(Exception e){
        	flag =false;
        }
        AjaxView ajaxView = new AjaxView(response);
        if(flag==true)
        {
        	ajaxView.setStatus((short) 1);
        }else{
        	ajaxView.setStatus((short) 0);
        }
        return ajaxView;
    }

	
	
	/**
	 * showFrom时调用,可以重载这个方法在mv上加入一些新的元素，补充重写进入表单的方法,例如编辑，
	 * 主要获取推荐资讯的数据还有该文化资讯的月刊
	 * @param request
	 * @param mv
	 */
	protected void onShowForm(HttpServletRequest request, ModelAndView mv)
	{
		//System.out.print("进入编辑最后阶段！");
		CulturalInformation culturalInformation = formBackingObject(request);
		try{
		List<CulturalInformation> CulturalInformationList = culturalInformationManager.getAllByIdArray(culturalInformation.getRecommendArrayId());
		List<MonthlyCultural>monthlyCulturalList =new ArrayList(culturalInformation.getMonthlyCultural());
		mv.addObject("reCulturalInformationList", CulturalInformationList);
		mv.addObject("monthlyCulturalList", monthlyCulturalList);
		}
		catch(Exception e){
			System.out.println("进入文化资讯onShowForm方法有误"+"");
		}
	}
	
	
	/**
	 * 重写删除方法
	 * @throws Exception 
	 */
	@Override
	public ModelAndView delete(HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		// 取得Form对应的Model。因为要先保存其名称，否则可能会连I18N数据也已经删除了；另外可以用于出错的时候恢复显示Form页面
		CulturalInformation entity = formBackingObject(request);
		try {
			// 删除并设置信息
			String entityId = request.getParameter(entityIdName);
			try{
				//删除索引
				CatalogHelper.getInstance().indexNotifyDeleteEventMethod(SearchConstants.CORE_NAME_CULTURAL,new Integer(entityId));
				}catch(Exception e)
				{
					System.out.println("单个删除文化资讯索引有误");
					e.printStackTrace();
				}
			if (!StringUtils.isEmpty(entityId)) {
				// 先构造提示信息，否则信息对应的记录可能也会被删除。
				String entityName = getEntityName(entity);
				String message = getMessage("common.deleted", new Object[] {
						getEntityTypeMessage(), entityName });
				entity = mgr.deleteById(new Integer(entityId));
				saveMessage(Message.info("common.deleted", getEntityTypeMessage(), entityName ));
			} else {
				saveMessage(Message.error("errors.invalid.delete.id", entityId));
			}
		} catch (ApplicationException e) {
			// 为了出错的时候可以恢复表单显示，构造errors，但是设置标记跳过绑定和验证
			request.setAttribute("SUPPRESS_BINDING", Boolean.TRUE);
			request.setAttribute("SUPPRESS_VALIDATION", Boolean.TRUE);
			BindException errors = null;
			ServletRequestDataBinder binder = bindAndValidate(request, entity);
			errors = new BindException(binder.getBindingResult());
			handleApplicationException(errors, e);
			return showForm(request, errors);
		}
		return getModelAndView(cancelFormView, null);
	}
	
	
	/**
	 * 重写批量删除方法
	 */
	@Override
	public ModelAndView multiDelete(HttpServletRequest request,HttpServletResponse response) 
	{
		// 取得要删除的记录的id的列表。注意：选择框的id要是"multiIds"。
		String[] ids = request.getParameterValues("multiIds");
		if (ids != null && ids.length > 0) {
				for(int i=0;i<ids.length;i++)
				{
					try{
					//更新文化资讯列表页索引
					CatalogHelper.getInstance().indexNotifyDeleteEventMethod(SearchConstants.CORE_NAME_CULTURAL,Integer.parseInt(ids[i]));
				    	}catch(Exception e){
						System.out.println("批量删除文化资讯列表页索引有误");
						e.printStackTrace();
					}
				}
			
		    mgr.deleteAllByIds(ids);
			saveMessage(Message.info("common.deleted.multi", new Object[] {getEntityTypeMessage(), ids.length }));
		}
		return getRedirectToActionView("search");	
	}
	
	
	
	/**
	 * 功能:保存月刊数据
	 * <p>作者 杨荣忠 2015-7-7 下午02:05:04
	 * @param mediaUrls_d
	 * @param culturalInformation
	 * @throws ParseException
	 */
	public void saveMonth(String mediaUrls_d[],CulturalInformation culturalInformation) throws ParseException{
		if( mediaUrls_d!=null&& mediaUrls_d.length>0&&culturalInformation.getType()==MONTH_TYPE){
			for(int i=0;i<mediaUrls_d.length;i++)
			{
				MonthlyCultural monthlyCultural =new MonthlyCultural();
				monthlyCultural.setImg(mediaUrls_d[i]);
				try
				{
					monthlyCultural.setCreateTime(CalenderTime.strtodate(CalenderTime.getToday("yyyy-MM-dd"),"yyyy-MM-dd"));
				}
				catch (ParseException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				monthlyCultural.setMonthlyCulturalId(culturalInformation.getId());
				monthlyCultural.setCulturalInformation(culturalInformation);
				//monthlyCulturalList.add(monthlyCultural);
				monthlyCulturalManager.merge(monthlyCultural);
			}
		}
	}
	
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.controller.GenericController getEntityName(java.lang.Object)
	 */
	@Override
	protected String getEntityName(CulturalInformation entity) {
		return entity.getCulturalInformationName();
	}
	

	/**
	 * 构造批量更新所需的model。
	 * <P>
	 * 本来这方法对大部分情况也是可以自动分析和转换的，但考虑到比较复杂和难以灵活（验证、缺省值、I18N等、Status转换等），暂时要求各模块自己实现。要求数据要先转换为正确的类型。
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected Map<Integer, Map<String, Object>> getMultiSaveModel(HttpServletRequest request) {
		//FIXME
		throw new RuntimeException("Not implemented yet!");
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.controller.BaseController#initController()
	 */
	@Override
	protected void initController() throws Exception {
		mgr = culturalInformationManager;
	}
	
	
	
	/**
	 * 缺省Action,列出缺省搜索条件的搜索结果列表。必须转给search处理。
	 * 
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 */
	public ModelAndView defaultAction(HttpServletRequest request,
			HttpServletResponse response) {
		return search(request, response);
	}

	@Override
	protected void onSave(HttpServletRequest request, CulturalInformation entity, BindException errors) {
		// TODO Auto-generated method stub
		
	}
	
	

}
