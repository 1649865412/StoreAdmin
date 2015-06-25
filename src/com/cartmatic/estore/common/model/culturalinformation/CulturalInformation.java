package com.cartmatic.estore.common.model.culturalinformation;

import com.cartmatic.estore.common.model.culturalinformation.base.CulturalInformationTbl;

/**
 * Model class for CulturalInformation. Add not database mapped fileds in this class.
 */
public class CulturalInformation extends CulturalInformationTbl {

  	/**
	 * Default Empty Constructor for class CulturalInformation
	 */
	public CulturalInformation () {
		super();
	}
	
	/**
	 * 定义实体的业务名取值； culturalInformationName
	 * 必须手工完成这个部分，否则编译不通过。
	 */
	public String getCulturalInformationName () {
		if (culturalInformationId == null)
	        return "";
	    else
			//返回一个指定有业务意义的属性值;
			//如：product的VO就用product.productName
	        return this.title;
	}
	
	/**
	 * Default Key Fields Constructor for class CulturalInformation
	 */
	public CulturalInformation (
		 Integer in_culturalInformationID
		) {
		super (
		  in_culturalInformationID
		);
	}

}
