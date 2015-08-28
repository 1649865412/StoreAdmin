package com.cartmatic.estore.branddynamic.service;

import java.util.List;

import com.cartmatic.estore.common.model.branddynamic.BrandDynamic;
import com.cartmatic.estore.common.model.culturalinformation.CulturalInformation;
import com.cartmatic.estore.core.service.GenericManager;

/**
 * Manager interface for BrandDynamic, responsible for business processing, and communicate between web and persistence layer.
 *
 */
public interface BrandDynamicManager extends GenericManager<BrandDynamic> {
	public List<BrandDynamic> getResutlType(Integer brandId);
}
