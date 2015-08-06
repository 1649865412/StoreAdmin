package com.cartmatic.estore.culturalinformation.service;

import java.util.List;

import com.cartmatic.estore.common.model.culturalinformation.CulturalInformation;
import com.cartmatic.estore.core.service.GenericManager;

/**
 * Manager interface for CulturalInformation, responsible for business processing, and communicate between web and persistence layer.
 *
 */
public interface CulturalInformationManager extends GenericManager<CulturalInformation> {
      public List<CulturalInformation> getResutlType(String type);
}
