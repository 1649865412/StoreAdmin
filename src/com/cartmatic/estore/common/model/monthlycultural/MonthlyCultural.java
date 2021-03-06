package com.cartmatic.estore.common.model.monthlycultural;

import com.cartmatic.estore.common.model.monthlycultural.base.MonthlyCulturalTbl;

/**
 * Model class for MonthlyCultural. Add not database mapped fileds in this class.
 */
public class MonthlyCultural extends MonthlyCulturalTbl {

  	/**
	 * Default Empty Constructor for class MonthlyCultural
	 */
	public MonthlyCultural () {
		super();
	}
	
	/**
	 * 定义实体的业务名取值； monthlyCulturalName
	 * 必须手工完成这个部分，否则编译不通过。
	 */
	public String getMonthlyCulturalName () {
		if (monthlyCulturalId == null)
	        return "";
	    else
			//返回一个指定有业务意义的属性值;
			//如：product的VO就用product.productName
	        return this.monthlyCulturalId.toString();
	}
	
	/**
	 * Default Key Fields Constructor for class MonthlyCultural
	 */
	public MonthlyCultural (
		 Integer in_monthlyCulturalId
		) {
		super (
		  in_monthlyCulturalId
		);
	}

}
