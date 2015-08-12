package com.cartmatic.estore.catalog.service.impl;

import java.util.List;

import com.cartmatic.estore.catalog.dao.BrandDao;
import com.cartmatic.estore.catalog.service.BrandManager;
import com.cartmatic.estore.common.model.catalog.Brand;
import com.cartmatic.estore.core.service.impl.GenericManagerImpl;


/**
 * Manager implementation for Brand, responsible for business processing, and communicate between web and persistence layer.
 */
public class BrandManagerImpl extends GenericManagerImpl<Brand> implements BrandManager {

	private BrandDao brandDao = null;

	/**
	 * @param brandDao
	 *            the brandDao to set
	 */
	public void setBrandDao(BrandDao brandDao) {
		this.brandDao = brandDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.service.impl.GenericManagerImpl#init()
	 */
	@Override
	protected void initManager() {
		dao = brandDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.service.impl.GenericManagerImpl#onDelete(java.lang.Object)
	 */
	@Override
	protected void onDelete(Brand entity) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cartmatic.estore.core.service.impl.GenericManagerImpl#onSave(java.lang.Object)
	 */
	@Override
	protected void onSave(Brand entity) {

	}

	public List<Brand> findAllBrands() {
		return getAllOrdered("sortOrder",true);
	}

	public Brand getBrandByCode(String brandCode) {
		Brand brand=dao.findUniqueByProperty("brandCode", brandCode);
		return brand;
	}

	public List<Brand> findBrandByName(String brandName) {
		return dao.findByProperty("brandName", brandName);
	}

	/**
	 * 功能:设计师模块搜索页，支持设计师名字与设计师品牌的模糊查询
	 * <p>作者 杨荣忠 2015-8-12 下午12:08:04
	 * @return
	 */
	public List<Brand> getSearch(String tags ){
		return brandDao.getSearch(tags);
	}
}
