
package com.cartmatic.estoresa.culturalinformation.web.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.cartmatic.estore.common.model.culturalinformation.CulturalInformation;
import com.cartmatic.estore.core.controller.GenericController;
import com.cartmatic.estore.core.search.SearchCriteria;
import com.cartmatic.estore.culturalinformation.service.CulturalInformationManager;


/**
 *  文化资讯弹出窗选择
 *  <code>CulturalSelectorController.java</code>
 *  <p>
 *  <p>Copyright  2015 All right reserved.
 *  @author admin 时间 2015-7-1 上午10:56:08	
 *  @version 1.0 
 *  </br>最后修改人 无
 */
public class CulturalSelectorController extends GenericController<CulturalInformation> {
	private CulturalInformationManager CulturalInformationManager=null;

	@SuppressWarnings("unchecked")
	public ModelAndView defaultAction(HttpServletRequest request,
			HttpServletResponse response) {
		if(request.getRequestURI().indexOf("culturalSelectorDataList.html")!=-1){
			return getData(request, response);
		}
		return new ModelAndView("culturalinformation/culturalSelector");
	}
	
	@SuppressWarnings("unchecked")
	private ModelAndView getData(HttpServletRequest request,
			HttpServletResponse response) {
		SearchCriteria searchCriteria = createSearchCriteria(request);
		List results = searchByCriteria(searchCriteria);
		request.setAttribute("supplierList", results);
		request.setAttribute("pagingId",request.getParameter("pagingId"));
		return new ModelAndView("culturalinformation/include/culturalSelectorDataList");
	}
	


	@Override
	protected String getEntityName(CulturalInformation entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void onSave(HttpServletRequest request, CulturalInformation entity,
			BindException errors) {
		// TODO Auto-generated method stub

	}
	
	

	public CulturalInformationManager getCulturalInformationManager() {
		return CulturalInformationManager;
	}


	public void setCulturalInformationManager(CulturalInformationManager culturalInformationManager) {
		CulturalInformationManager = culturalInformationManager;
	}


	@Override
	protected Map<Integer, Map<String, Object>> getMultiSaveModel(
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void initController() throws Exception {
		mgr = CulturalInformationManager;
	}


}
