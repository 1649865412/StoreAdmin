package com.cartmatic.estore.culturalinformation.dao;

import java.util.List;

import com.cartmatic.estore.common.model.culturalinformation.CulturalInformation;
import com.cartmatic.estore.core.dao.GenericDao;
/**
 * Dao interface for CulturalInformation.
 */
public interface CulturalInformationDao extends GenericDao<CulturalInformation> {
	public List<CulturalInformation>getResutlType(String type);
}