package com.cartmatic.estoresa.talentmanager.web.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.cartmatic.estore.common.model.talentmanager.TalentShow;
import com.cartmatic.estore.core.controller.GenericController;
import com.cartmatic.estore.core.search.SearchCriteria;
import com.cartmatic.estore.talentmanager.service.TalentShowManager;

/**
 * 文化资讯弹出窗选择 <code>CulturalSelectorController.java</code>
 * <p>
 * <p>
 * Copyright 2015 All right reserved.
 * 
 * @author admin 时间 2015-7-1 上午10:56:08
 * @version 1.0 </br>最后修改人 无
 */
public class TalentShowSelectorController extends GenericController<TalentShow>
{
	private TalentShowManager talentShowManager = null;

	public void setTalentShowManager(TalentShowManager inMgr) {
		this.talentShowManager = inMgr;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView defaultAction(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();
	
		if(request.getRequestURI().indexOf("talentShowSelectorDataList.html")!=-1){
			return getData(request, response);
		}
		return new ModelAndView("talentmanager/talentShowSelector");
		//List<TalentShow> TalentShowList = talentShowManager.getAll();
		//return getModelAndView("talentmanager/talentShowSelector", "reTalentShowList", TalentShowList);
	}

	
	@SuppressWarnings("unchecked")
	private ModelAndView getData(HttpServletRequest request,
			HttpServletResponse response) {
		SearchCriteria searchCriteria = createSearchCriteria(request);
		List results = searchByCriteria(searchCriteria);
		request.setAttribute("supplierList", results);
		request.setAttribute("pagingId",request.getParameter("pagingId"));
		return new ModelAndView("talentmanager/include/talentShowSelectorDataList");
	}
	
	
/*	@SuppressWarnings("unchecked")
	private ModelAndView getData(HttpServletRequest request, HttpServletResponse response, List<TalentShow> TalentShowList) {
		SearchCriteria searchCriteria = createSearchCriteria(request);
		List results = searchByCriteria(searchCriteria);
		request.setAttribute("supplierList", results);
		request.setAttribute("pagingId", request.getParameter("pagingId"));
		return getModelAndView("talentmanager/include/talentShowSelectorDataList", "reTalentShowList", TalentShowList);

	}*/

	@Override
	protected String getEntityName(TalentShow entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void onSave(HttpServletRequest request, TalentShow entity, BindException errors) {
		// TODO Auto-generated method stub

	}

	@Override
	protected Map<Integer, Map<String, Object>> getMultiSaveModel(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected void initController() throws Exception {
		mgr = talentShowManager;
	}

}
