package com.cartmatic.estore.branddynamic.dao;

import java.util.List;

import com.cartmatic.estore.common.model.branddynamic.BrandDynamic;
import com.cartmatic.estore.core.dao.GenericDao;
/**
 * Dao interface for BrandDynamic.
 */
public interface BrandDynamicDao extends GenericDao<BrandDynamic> {

	List<BrandDynamic> getResutlType(Integer brandId);

}