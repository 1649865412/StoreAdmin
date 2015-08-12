package com.cartmatic.estoresa.producttalenshow.web.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cartmatic.estore.common.model.producttalenshow.ProductTalenshow;
import com.cartmatic.estore.core.controller.GenericController;
import com.cartmatic.estore.core.view.AjaxView;
import com.cartmatic.estore.producttalenshow.service.ProductTalenshowManager;

public class ProductTalenshowController extends GenericController<ProductTalenshow> {
    private ProductTalenshowManager productTalenshowManager = null;

    public void setProductTalenshowManager(ProductTalenshowManager inMgr) {
        this.productTalenshowManager = inMgr;
    }

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.controller.GenericController getEntityName(java.lang.Object)
	 */
	@Override
	protected String getEntityName(ProductTalenshow entity) {
		return entity.getProductTalenshowName();
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
		mgr = productTalenshowManager;
	}
	
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.controller.GenericController onSave(javax.servlet.http.HttpServletRequest,
	 *      java.lang.Object, org.springframework.validation.BindException)
	 */
	@Override
	protected void onSave(HttpServletRequest request, ProductTalenshow entity, BindException errors) {
		
	}
	

	/**
	 * 在产品详情页删除一条记录。
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView deleteOne(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
      //  System.out.print("id:"+request.getParameter("productTalenShowId"));
        AjaxView ajaxView = new AjaxView(response);
        Short flag = 0;
        try{
        	productTalenshowManager.deleteById(Integer.parseInt(request.getParameter("productTalenShowId")));
        	flag =1;
        }
          catch(Exception e)
        {
        	
        }
          ajaxView.setStatus(flag);
          return ajaxView;
	}

}
