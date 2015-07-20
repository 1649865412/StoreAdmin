package com.cartmatic.estore.sekillproduct.service;

import java.util.List;
import java.util.Map;

import com.cartmatic.estore.common.model.sekillproduct.SekillProduct;
import com.cartmatic.estore.core.service.GenericManager;

/**
 * Manager interface for SekillProduct, responsible for business processing, and communicate between web and persistence layer.
 *
 */
public interface SekillProductManager extends GenericManager<SekillProduct> {
      public void saveSekillProductList(SekillProduct entity);
      public List<SekillProduct> getObject(String sqlName,Map<String, Object> param);
}
