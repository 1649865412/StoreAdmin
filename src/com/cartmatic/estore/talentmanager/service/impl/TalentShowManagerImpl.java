package com.cartmatic.estore.talentmanager.service.impl;

import com.cartmatic.estore.common.model.talentmanager.TalentShow;
import com.cartmatic.estore.core.service.impl.GenericManagerImpl;
import com.cartmatic.estore.talentmanager.service.TalentShowManager;
import com.cartmatic.estore.talentmanager.dao.TalentShowDao;


/**
 * Manager implementation for TalentShow, responsible for business processing, and communicate between web and persistence layer.
 */
public class TalentShowManagerImpl extends GenericManagerImpl<TalentShow> implements TalentShowManager {

	private TalentShowDao talentShowDao = null;

	/**
	 * @param talentShowDao
	 *            the talentShowDao to set
	 */
	public void setTalentShowDao(TalentShowDao talentShowDao) {
		this.talentShowDao = talentShowDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.service.impl.GenericManagerImpl#init()
	 */
	@Override
	protected void initManager() {
		dao = talentShowDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.service.impl.GenericManagerImpl#onDelete()
	 */
	@Override
	protected void onDelete(TalentShow entity) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.service.impl.GenericManagerImpl#onSave()
	 */
	@Override
	protected void onSave(TalentShow entity) {

	}

}
