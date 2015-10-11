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
		try{
			if(type != null){
				result =findByHql("from CulturalInformation c where c.type=? and c.state=0 order by c.releaseTime desc", Integer.parseInt(type));
				}else{
					result =findByHql("from CulturalInformation c where c.state=0 order by c.releaseTime desc");
				}
		}catch(Exception e ){
			
		}
		return result;
	}
}
