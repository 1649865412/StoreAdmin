package com.cartmatic.estoresa.culturalinformation.web.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

import com.cartmatic.estore.common.helper.CatalogHelper;
import com.cartmatic.estore.common.model.culturalinformation.CulturalInformation;
import com.cartmatic.estore.core.controller.GenericController;
import com.cartmatic.estore.core.exception.ApplicationException;
import com.cartmatic.estore.core.model.Message;
import com.cartmatic.estore.culturalinformation.service.CulturalInformationManager;
import com.cartmatic.estore.textsearch.SearchConstants;

public class CulturalInformationController extends GenericController<CulturalInformation> {
    private CulturalInformationManager culturalInformationManager = null;

    public void setCulturalInformationManager(CulturalInformationManager inMgr) {
        this.culturalInformationManager = inMgr;
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
	 * 重写保存方法
	 */
	protected void  onSave(HttpServletRequest request, CulturalInformation entity, BindException errors) 
	{
            culturalInformationManager.save(entity);
			System.out.println("entityID========"+entity.getId());
			//更新文化资讯列表页索引
			CatalogHelper.getInstance().indexNotifyUpdateEventMethod(SearchConstants.CORE_NAME_CULTURAL, entity.getId());
			saveMessage(Message.info("common.added", new Object[] {getEntityTypeMessage(), getEntityName(entity)}));	
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

}
