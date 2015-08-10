package com.cartmatic.estore.producttalenshow.service.impl;

import com.cartmatic.estore.common.model.producttalenshow.ProductTalenshow;
import com.cartmatic.estore.core.service.impl.GenericManagerImpl;
import com.cartmatic.estore.producttalenshow.service.ProductTalenshowManager;
import com.cartmatic.estore.producttalenshow.dao.ProductTalenshowDao;


/**
 * Manager implementation for ProductTalenshow, responsible for business processing, and communicate between web and persistence layer.
 */
public class ProductTalenshowManagerImpl extends GenericManagerImpl<ProductTalenshow> implements ProductTalenshowManager {

	private ProductTalenshowDao productTalenshowDao = null;

	/**
	 * @param productTalenshowDao
	 *            the productTalenshowDao to set
	 */
	public void setProductTalenshowDao(ProductTalenshowDao productTalenshowDao) {
		this.productTalenshowDao = productTalenshowDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.service.impl.GenericManagerImpl#init()
	 */
	@Override
	protected void initManager() {
		dao = productTalenshowDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.service.impl.GenericManagerImpl#onDelete()
	 */
	@Override
	protected void onDelete(ProductTalenshow entity) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.service.impl.GenericManagerImpl#onSave()
	 */
	@Override
	protected void onSave(ProductTalenshow entity) {

	}

}
