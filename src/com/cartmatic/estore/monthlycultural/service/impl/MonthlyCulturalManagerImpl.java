package com.cartmatic.estore.monthlycultural.service.impl;

import com.cartmatic.estore.common.model.monthlycultural.MonthlyCultural;
import com.cartmatic.estore.core.service.impl.GenericManagerImpl;
import com.cartmatic.estore.monthlycultural.service.MonthlyCulturalManager;
import com.cartmatic.estore.monthlycultural.dao.MonthlyCulturalDao;


/**
 * Manager implementation for MonthlyCultural, responsible for business processing, and communicate between web and persistence layer.
 */
public class MonthlyCulturalManagerImpl extends GenericManagerImpl<MonthlyCultural> implements MonthlyCulturalManager {

	private MonthlyCulturalDao monthlyCulturalDao = null;

	/**
	 * @param monthlyCulturalDao
	 *            the monthlyCulturalDao to set
	 */
	public void setMonthlyCulturalDao(MonthlyCulturalDao monthlyCulturalDao) {
		this.monthlyCulturalDao = monthlyCulturalDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.service.impl.GenericManagerImpl#init()
	 */
	@Override
	protected void initManager() {
		dao = monthlyCulturalDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.service.impl.GenericManagerImpl#onDelete()
	 */
	@Override
	protected void onDelete(MonthlyCultural entity) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.service.impl.GenericManagerImpl#onSave()
	 */
	@Override
	protected void onSave(MonthlyCultural entity) {

	}

}
