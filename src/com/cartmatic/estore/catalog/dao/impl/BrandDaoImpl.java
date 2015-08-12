package com.cartmatic.estore.catalog.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cartmatic.estore.catalog.dao.BrandDao;
import com.cartmatic.estore.common.model.catalog.Brand;
import com.cartmatic.estore.common.model.sekillproduct.SekillProduct;
import com.cartmatic.estore.core.dao.impl.HibernateGenericDaoImpl;

/**
 * Dao implementation for Brand.
*/
public class BrandDaoImpl extends HibernateGenericDaoImpl<Brand> implements BrandDao {
	

	public static String SqlSearch ="BRAND_SEARCH";
	
	/**
	 * 功能:设计师模块搜索页，支持设计师名字与设计师品牌的模糊查询
	 * <p>作者 杨荣忠 2015-8-12 下午12:08:04
	 * @return
	 */
	public List<Brand> getSearch(String tags ){
		 Map<String, Object> paramValue =new HashMap();
		 paramValue.put("tags", tags);
		 List<Brand> result = getObjectList(SqlSearch,new Brand(),paramValue);
		 return result;
	}
}
