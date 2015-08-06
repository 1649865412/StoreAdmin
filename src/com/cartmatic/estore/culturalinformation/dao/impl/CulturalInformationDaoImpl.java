package com.cartmatic.estore.culturalinformation.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.cartmatic.estore.common.model.culturalinformation.CulturalInformation;
import com.cartmatic.estore.core.dao.impl.HibernateGenericDaoImpl;
import com.cartmatic.estore.culturalinformation.dao.CulturalInformationDao;

/**
 * Dao implementation for CulturalInformation.
*/
public class CulturalInformationDaoImpl extends HibernateGenericDaoImpl<CulturalInformation> implements CulturalInformationDao {
	public List<CulturalInformation>getResutlType(String type){
		List<CulturalInformation> result =new ArrayList();
		if(type != null){
		result =findByHql("from CulturalInformation where type=? order by createTime asc", type);
		}else{
			result =findByHql("from CulturalInformation where state=0 order by createTime asc");
		}
		return result;
	}
}
