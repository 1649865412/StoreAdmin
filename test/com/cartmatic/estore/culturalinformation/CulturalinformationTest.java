package com.cartmatic.estore.culturalinformation;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cartmatic.estore.common.helper.CatalogHelper;
import com.cartmatic.estore.common.model.culturalinformation.CulturalInformation;
import com.cartmatic.estore.culturalinformation.service.CulturalInformationManager;
import com.cartmatic.estore.framework.test.BaseTransactionalTestCase;
import com.cartmatic.estore.textsearch.SearchConstants;
import com.cartmatic.estore.textsearch.model.SearchResult;


public class CulturalinformationTest  extends BaseTransactionalTestCase
{
	    @Autowired
		private CulturalInformationManager culturalInformationManager = null;
	    
	    /**
	     * 功能:
	     * <p>作者 杨荣忠 2015-6-29 上午10:55:32
	     * @throws Exception
	     */
	    @Test
		public void testBuildCulturalinIndex() throws Exception{
	    	System.out.println("进入solr索引测试！");
	    	System.out.println("CulturalInformationManager:"+culturalInformationManager);
	    	
	    	CulturalInformation CulturalInformation = new CulturalInformation();
	    	
	     /*   protected Integer culturalInformationId;
	    	protected String title;
	    	protected String textIntroduction;
	    	protected Integer commentNumber;
	    	protected java.util.Date releaseTime;
	    	protected Integer readNumber;
	    	protected String writer;
	    	protected Integer type;
	    	protected String logoImg;
	    	protected String imgOne;
	    	protected String imgTwo;
	    	protected Integer brandId;
	    	protected Integer sortOrder;
	    	protected java.util.Date createTime;
	    	protected String videoAddress;
	    	protected String backOne;
	    	protected String backTwo;
	    	protected String metaKeywork;*/
	    	
	    	CulturalInformation.setTitle("测试标题");
	    	CulturalInformation.setTextIntroduction("测试文件内容");
	    	CulturalInformation.setWriter("杨荣忠");
	    	CulturalInformation.setVideoAddress("测试地址");
	    	
	    	culturalInformationManager.save(CulturalInformation);
	    	
	    	Integer productIds = CulturalInformation.getId();
	    	
	    	CatalogHelper.getInstance().indexNotifyUpdateEventMethod(SearchConstants.CORE_NAME_CULTURAL,productIds);
	    	
	    
	         
	    	//CatalogHelper.getInstance().indexNotifyDeleteEventMethod( productIds, SearchConstants.CORE_NAME_CULTURAL);
		}

}
