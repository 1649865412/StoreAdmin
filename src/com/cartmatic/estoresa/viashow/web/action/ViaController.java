package com.cartmatic.estoresa.viashow.web.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cartmatic.estore.core.controller.GenericController;
import com.cartmatic.estore.core.view.AjaxView;
import com.cartmatic.estore.common.model.viashow.Via;
import com.cartmatic.estore.viashow.service.ViaManager;

public class ViaController extends GenericController<Via> {
    private ViaManager viaManager = null;

    public void setViaManager(ViaManager inMgr) {
        this.viaManager = inMgr;
    }

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.controller.GenericController getEntityName(java.lang.Object)
	 */
	@Override
	protected String getEntityName(Via entity) {
		return entity.getViaName();
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
		mgr = viaManager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.controller.GenericController onSave(javax.servlet.http.HttpServletRequest,
	 *      java.lang.Object, org.springframework.validation.BindException)
	 */
	@Override
	protected void onSave(HttpServletRequest request, Via entity, BindException errors) {
	}


	
    /**
     * 功能:时装周报名记录
	 * 返回结果
	 * 默认情况下
	 * 1表示成功
	 * 0表示失败
     * <p>作者 杨荣忠 2015-5-18 下午02:19:58
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
	public ModelAndView addSave(HttpServletRequest request, HttpServletResponse response,Via via) throws Exception
    {
        boolean flag =false;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
     	via.setBark(df.format(new Date()).toString());
        flag= doCheck(via);
        AjaxView ajaxView = new AjaxView(response);
        if(flag==true)
        {
        	if(saveAdd(via)){
        		//异步添加成功
        		ajaxView.setStatus((short) 1);	
        	}else{
        		//异步添加失败
        		ajaxView.setStatus((short) 3);	
        	}
        }else{
        	//异步重复
        	ajaxView.setStatus((short) 2);
        }
        return ajaxView;
    }
    
    
	/**
	 * 功能:邮箱检测是否已存在
	 * <p>作者 杨荣忠 2015-8-16 下午12:09:00
	 * @param via
	 * @return
	 */
    public boolean  doCheck(Via via){
 	   boolean flag= false;
 	   try{
 		  List<Via> value =    viaManager.findByProperty("email", via.getEmail());
 		  if(CollectionUtils.isEmpty(value)){
 			 flag=true;
 		  }
 	   }catch(Exception e){
 		   e.printStackTrace();
 	   }
 	   return flag;
    }
    
   /**
    * 功能:保存
    * <p>作者 杨荣忠 2015-8-16 下午12:09:21
    * @param via
    * @return
    */
   public boolean  saveAdd(Via via){
	   boolean flag= false;
	   try{
		   viaManager.save(via);
		   flag= true;
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   return flag;
   }
}
