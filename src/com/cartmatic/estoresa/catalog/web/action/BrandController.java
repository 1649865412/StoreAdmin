package com.cartmatic.estoresa.catalog.web.action;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

import com.cartmatic.estore.catalog.service.BrandManager;
import com.cartmatic.estore.catalog.service.ProductManager;
import com.cartmatic.estore.common.model.branddynamic.BrandDynamic;
import com.cartmatic.estore.common.model.catalog.Brand;
import com.cartmatic.estore.common.model.catalog.BrandDynamicModel;
import com.cartmatic.estore.common.model.catalog.Product;
import com.cartmatic.estore.common.model.culturalinformation.CulturalInformation;
import com.cartmatic.estore.core.controller.GenericController;
import com.cartmatic.estore.core.exception.ApplicationException;
import com.cartmatic.estore.core.model.BaseObject;
import com.cartmatic.estore.core.model.Message;
import com.cartmatic.estore.core.view.AjaxView;
import com.cartmatic.estore.culturalinformation.service.CulturalInformationManager;
import com.cartmatic.estore.culturalinformation.util.CalenderTime;

public class BrandController extends GenericController<Brand> {
	
    private BrandManager brandManager = null;

    private CulturalInformationManager culturalInformationManager = null;
    
    
    private ProductManager				productManager				= null;
    

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

	public void setBrandManager(BrandManager inMgr) {
        this.brandManager = inMgr;
    }
    
	public CulturalInformationManager getCulturalInformationManager() {
		return culturalInformationManager;
	}
	

	public void setCulturalInformationManager(CulturalInformationManager culturalInformationManager) {
		this.culturalInformationManager = culturalInformationManager;
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.controller.GenericController#getEntityName(java.lang.Object)
	 */
	@Override
	protected String getEntityName(Brand entity) {
		return entity.getBrandName();
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
		mgr = brandManager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.controller.GenericController#onSave(javax.servlet.http.HttpServletRequest,
	 *      java.lang.Object, org.springframework.validation.BindException)
	 */
	@Override
	protected void onSave(HttpServletRequest request, Brand entity, BindException errors) {
		Brand tempBrand=brandManager.getBrandByCode(entity.getBrandCode());
		if(tempBrand!=null&&(entity.getBrandId()==null||(entity.getBrandId().intValue()!=tempBrand.getBrandId().intValue()))){
			String msgKey = "brand.brandCode.repeated";
			errors.rejectValue("brandCode", msgKey);
		}
	}
	
	
	/**
	 * 重写保存
	 */
	public ModelAndView save(HttpServletRequest request,
			HttpServletResponse response,BrandDynamicModel brandDynamicModel) throws Exception {
		// 取得Form对应的Model
		Brand entity = formBackingObject(request);
		BindException errors = null;
		String mediaUrls_d[] =request.getParameterValues("productMedia_urls_d");
		try {
			ServletRequestDataBinder binder = bindAndValidate(request, entity);
			errors = new BindException(binder.getBindingResult());
			onSave(request, entity, errors);
			// 传给子类的实现，后者可以继续验证和加入错误到errors
			if (!errors.hasErrors()) {// 里面如果出错应该抛出异常
				mgr.save(entity);
				saveMonth(brandDynamicModel,entity);
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
	 * 功能:保存设计师动态数据
	 * <p>作者 杨荣忠 2015-7-7 下午02:05:04
	 * @param mediaUrls_d
	 * @param culturalInformation
	 * @throws ParseException
	 */
	public void saveMonth(BrandDynamicModel brandDynamicModel,Brand entity ) throws ParseException{
	/*	if( mediaUrls_d!=null&& mediaUrls_d.length>0){
			for(int i=0;i<mediaUrls_d.length;i++)
			{
				BrandDynamic brandDynamic =new BrandDynamic();
				brandDynamic.setImg(mediaUrls_d[i]);
				try
				{
					brandDynamic.setCreateTime(CalenderTime.strtodate(CalenderTime.getToday("yyyy-MM-dd"),"yyyy-MM-dd"));
				}
				catch (ParseException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//brandDynamic.setMonthlyCulturalId(culturalInformation.getId());
				//brandDynamic.setCulturalInformation(culturalInformation);
				//monthlyCulturalList.add(monthlyCultural);
				//monthlyCulturalManager.merge(monthlyCultural);
			}
		}*/
		if(brandDynamicModel!=null)
		{
			 String array[] =  brandDynamicModel.getImgArray();
		//	 int length = 
		}
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
		Brand brand = formBackingObject(request);
		try
		{
		   // System.out.print("id:"+brand.getCulturalRecommendId());
			List<CulturalInformation> CulturalInformationList = culturalInformationManager.getAllByIdArray(brand.getCulturalRecommendId());
			mv.addObject("reCulturalInformationList", CulturalInformationList);
	       // System.out.print("id:"+brand.getProductRecommendId());
			List<Product> ProductList = productManager.getAllByIdArray(brand.getProductRecommendId());
			mv.addObject("reProductList", ProductList);
			
		}
		catch(Exception e){
			System.out.println("进入文化资讯onShowForm方法有误");
		}
	}
	
	
	/**
	 * 功能:异步获取品牌
	 * <p>作者 杨荣忠 2015-7-9 上午11:46:58
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ModelAndView getBrands(HttpServletRequest request, HttpServletResponse response) throws IOException {
		AjaxView ajaxView=new AjaxView(response);
		List<Brand>brandList=brandManager.getAllOrdered("brandName", true);
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(new String[]{"sortOrder", "website","logo","version","products","firstKeyColumnName","id","integerId"});
		JSON brandJsonList = JSONSerializer.toJSON(brandList,jsonConfig);
		ajaxView.setData(brandJsonList);
		return ajaxView;
	}
}
