package com.cartmatic.estore.culturalinformation.service.impl;

import java.util.List;

import com.cartmatic.estore.common.model.culturalinformation.CulturalInformation;
import com.cartmatic.estore.core.service.impl.GenericManagerImpl;
import com.cartmatic.estore.culturalinformation.service.CulturalInformationManager;
import com.cartmatic.estore.culturalinformation.dao.CulturalInformationDao;


/**
 * Manager implementation for CulturalInformation, responsible for business processing, and communicate between web and persistence layer.
 */
public class CulturalInformationManagerImpl extends GenericManagerImpl<CulturalInformation> implements CulturalInformationManager {

	private CulturalInformationDao culturalInformationDao = null;

	
    public List<CulturalInformation>getResutlType(String type){
        return     	  culturalInformationDao.getResutlType(type);
    }
	/**
	 * @param culturalInformationDao
	 *            the culturalInformationDao to set
	 */
	public void setCulturalInformationDao(CulturalInformationDao culturalInformationDao) {
		this.culturalInformationDao = culturalInformationDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.service.impl.GenericManagerImpl#init()
	 */
	@Override
	protected void initManager() {
		dao = culturalInformationDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.service.impl.GenericManagerImpl#onDelete()
	 */
	@Override
	protected void onDelete(CulturalInformation entity) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.service.impl.GenericManagerImpl#onSave()
	 */
	@Override
	protected void onSave(CulturalInformation entity) {

	}

}
