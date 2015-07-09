package com.cartmatic.estoresa.branddynamic.web.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;

import com.cartmatic.estore.core.controller.GenericController;
import com.cartmatic.estore.common.model.branddynamic.BrandDynamic;
import com.cartmatic.estore.branddynamic.service.BrandDynamicManager;

public class BrandDynamicController extends GenericController<BrandDynamic> {
    private BrandDynamicManager brandDynamicManager = null;

    public void setBrandDynamicManager(BrandDynamicManager inMgr) {
        this.brandDynamicManager = inMgr;
    }

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.controller.GenericController getEntityName(java.lang.Object)
	 */
	@Override
	protected String getEntityName(BrandDynamic entity) {
		return entity.getBrandDynamicName();
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
		mgr = brandDynamicManager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.controller.GenericController onSave(javax.servlet.http.HttpServletRequest,
	 *      java.lang.Object, org.springframework.validation.BindException)
	 */
	@Override
	protected void onSave(HttpServletRequest request, BrandDynamic entity, BindException errors) {
	}

}
