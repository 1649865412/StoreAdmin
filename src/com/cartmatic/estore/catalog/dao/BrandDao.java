package com.cartmatic.estore.catalog.dao;

import java.util.List;

import com.cartmatic.estore.common.model.catalog.Brand;
import com.cartmatic.estore.core.dao.GenericDao;
/**
 * Dao interface for Brand.
 */
public interface BrandDao extends GenericDao<Brand> {
	/**
	 * 功能:设计师模块搜索页，支持设计师名字与设计师品牌的模糊查询
	 * <p>作者 杨荣忠 2015-8-12 下午12:08:04
	 * @return
	 */
	public List<Brand> getSearch(String tags );
}