package com.cartmatic.estore.branddynamic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.cartmatic.estore.branddynamic.dao.BrandDynamicDao;
import com.cartmatic.estore.common.model.branddynamic.BrandDynamic;
import com.cartmatic.estore.common.model.culturalinformation.CulturalInformation;
import com.cartmatic.estore.core.dao.impl.HibernateGenericDaoImpl;

/**
 * Dao implementation for BrandDynamic.
*/
public class BrandDynamicDaoImpl extends HibernateGenericDaoImpl<BrandDynamic> implements BrandDynamicDao {
	public List<BrandDynamic> getResutlType(Integer brandId){
		List<BrandDynamic> result =new ArrayList();
		try{
				result =findByHql("from BrandDynamic where brandId=? order by createTime asc", brandId);
		}catch(Exception e ){
			
		}
		return result;
	}
}
