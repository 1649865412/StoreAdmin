package com.cartmatic.estoresa.talentmanager.web.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.cartmatic.estore.catalog.service.ProductManager;
import com.cartmatic.estore.common.model.producttalenshow.ProductTalenshow;
import com.cartmatic.estore.common.model.talentmanager.TalentShow;
import com.cartmatic.estore.core.controller.GenericController;
import com.cartmatic.estore.talentmanager.service.TalentShowManager;

public class TalentShowController extends GenericController<TalentShow> {
    private TalentShowManager talentShowManager = null;
    private ProductManager	productManager	= null;

    public TalentShowManager getTalentShowManager() {
		return talentShowManager;
	}

	public void setTalentShowManager(TalentShowManager inMgr) {
        this.talentShowManager = inMgr;
    }

	public ProductManager getProductManager() {
		return productManager;
	}

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.controller.GenericController getEntityName(java.lang.Object)
	 */
	@Override
	protected String getEntityName(TalentShow entity) {
		return entity.getTalentShowName();
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
		mgr = talentShowManager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.controller.GenericController onSave(javax.servlet.http.HttpServletRequest,
	 *      java.lang.Object, org.springframework.validation.BindException)
	 */
	@Override
	protected void onSave(HttpServletRequest request, TalentShow entity, BindException errors) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
     	entity.setCreatTime(df.format(new Date()));
	}
	
	/**
	 * 功能:做产品详情页里嵌入达人秀功能选择
	 * <p>作者 杨荣忠 2015-8-10 下午05:10:03
	 * @param request
	 * @return
	 */
	public ModelAndView productAddTalent(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv =new ModelAndView("/talentmanager/include/talentProductShowForm");
		String productId =request.getParameter("productId");
		System.out.print("productId:"+productId);
		if(productId!=null){
			try{
				Set<ProductTalenshow>productTalenshowList = 	productManager.getById(Integer.parseInt(productId)).getProductTalenshowValues();
				mv.addObject("productTalenshowList", productTalenshowList);
			}catch(Exception e){
			   
			}
		}
		return mv;
	}
}
