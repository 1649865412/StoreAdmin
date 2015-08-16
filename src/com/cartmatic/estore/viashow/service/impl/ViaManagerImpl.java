package com.cartmatic.estore.viashow.service.impl;

import com.cartmatic.estore.common.model.viashow.Via;
import com.cartmatic.estore.core.service.impl.GenericManagerImpl;
import com.cartmatic.estore.viashow.service.ViaManager;
import com.cartmatic.estore.viashow.dao.ViaDao;


/**
 * Manager implementation for Via, responsible for business processing, and communicate between web and persistence layer.
 */
public class ViaManagerImpl extends GenericManagerImpl<Via> implements ViaManager {

	private ViaDao viaDao = null;

	/**
	 * @param viaDao
	 *            the viaDao to set
	 */
	public void setViaDao(ViaDao viaDao) {
		this.viaDao = viaDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.service.impl.GenericManagerImpl#init()
	 */
	@Override
	protected void initManager() {
		dao = viaDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.service.impl.GenericManagerImpl#onDelete()
	 */
	@Override
	protected void onDelete(Via entity) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.service.impl.GenericManagerImpl#onSave()
	 */
	@Override
	protected void onSave(Via entity) {

	}

}
