package com.cartmatic.estoresa.culturalinformation.web.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;

import com.cartmatic.estore.core.controller.GenericController;
import com.cartmatic.estore.core.model.Message;
import com.cartmatic.estore.common.model.culturalinformation.CulturalInformation;
import com.cartmatic.estore.common.model.sekillproduct.SekillProduct;
import com.cartmatic.estore.culturalinformation.service.CulturalInformationManager;

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
	protected void  onSave(HttpServletRequest request, CulturalInformation entity, BindException errors) {
		    
		    System.out.println("onSave");
			culturalInformationManager.save(entity);
			saveMessage(Message.info("common.added", new Object[] {getEntityTypeMessage(), getEntityName(entity)}));	
		
	}

}
