package com.cartmatic.estore.branddynamic.service.impl;

import java.util.List;

import com.cartmatic.estore.common.model.branddynamic.BrandDynamic;
import com.cartmatic.estore.core.service.impl.GenericManagerImpl;
import com.cartmatic.estore.branddynamic.service.BrandDynamicManager;
import com.cartmatic.estore.branddynamic.dao.BrandDynamicDao;


/**
 * Manager implementation for BrandDynamic, responsible for business processing, and communicate between web and persistence layer.
 */
public class BrandDynamicManagerImpl extends GenericManagerImpl<BrandDynamic> implements BrandDynamicManager {

	private BrandDynamicDao brandDynamicDao = null;
	
	public List<BrandDynamic> getResutlType(Integer brandId){
		return brandDynamicDao.getResutlType(brandId);
		
	}

	/**
	 * @param brandDynamicDao
	 *            the brandDynamicDao to set
	 */
	public void setBrandDynamicDao(BrandDynamicDao brandDynamicDao) {
		this.brandDynamicDao = brandDynamicDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.service.impl.GenericManagerImpl#init()
	 */
	@Override
	protected void initManager() {
		dao = brandDynamicDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.service.impl.GenericManagerImpl#onDelete()
	 */
	@Override
	protected void onDelete(BrandDynamic entity) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.service.impl.GenericManagerImpl#onSave()
	 */
	@Override
	protected void onSave(BrandDynamic entity) {

	}

}
