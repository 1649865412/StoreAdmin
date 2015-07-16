package com.cartmatic.estore.sekillproduct.dao;

import java.util.List;
import java.util.Map;

import com.cartmatic.estore.common.model.sekillproduct.SekillProduct;
import com.cartmatic.estore.core.dao.GenericDao;
/**
 * Dao interface for SekillProduct.
 */
public interface SekillProductDao extends GenericDao<SekillProduct> {
	public List<SekillProduct> getObject(String sqlName,Map<String, Object> param);
}