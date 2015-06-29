package com.cartmatic.estore.culturalinformation;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cartmatic.estore.cart.dao.ShoppingcartDao;
import com.cartmatic.estore.common.helper.CatalogHelper;
import com.cartmatic.estore.culturalinformation.service.CulturalInformationManager;
import com.cartmatic.estore.framework.test.BaseTransactionalTestCase;


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
	    	CatalogHelper.getInstance().indexNotifyUpdateEvent();
		}

}
