package com.cartmatic.estore.sekillproduct.dao.impl;

import java.util.List;
import java.util.Map;

import com.cartmatic.estore.common.model.sekillproduct.SekillProduct;
import com.cartmatic.estore.core.dao.impl.HibernateGenericDaoImpl;
import com.cartmatic.estore.sekillproduct.dao.SekillProductDao;
import com.cartmatic.estore.sekillproduct.util.SekillTool;

/**
 * Dao implementation for SekillProduct.
*/
public class SekillProductDaoImpl extends HibernateGenericDaoImpl<SekillProduct> implements SekillProductDao {
	
	public List<SekillProduct> getObject(String sqlName,Map<String, Object> param)
	{
		 List<SekillProduct> result = getObjectList(sqlName,new SekillProduct(),param);
		 return result;
	}
	
}
