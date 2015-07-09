package com.cartmatic.estore.common.model.branddynamic;

import com.cartmatic.estore.common.model.branddynamic.base.BrandDynamicTbl;

/**
 * Model class for BrandDynamic. Add not database mapped fileds in this class.
 */
public class BrandDynamic extends BrandDynamicTbl {

  	/**
	 * Default Empty Constructor for class BrandDynamic
	 */
	public BrandDynamic () {
		super();
	}
	
	/**
	 * 定义实体的业务名取值； brandDynamicName
	 * 必须手工完成这个部分，否则编译不通过。
	 */
	public String getBrandDynamicName () {
		if (brandDynamicId == null)
	        return "";
	    else
			//返回一个指定有业务意义的属性值;
			//如：product的VO就用product.productName
	        return this.brandDynamicId.toString();
	}
	
	/**
	 * Default Key Fields Constructor for class BrandDynamic
	 */
	public BrandDynamic (
		 Integer in_brandDynamicId
		) {
		super (
		  in_brandDynamicId
		);
	}

}
