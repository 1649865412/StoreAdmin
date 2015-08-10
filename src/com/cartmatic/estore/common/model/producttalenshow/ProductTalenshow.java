package com.cartmatic.estore.common.model.producttalenshow;

import com.cartmatic.estore.common.model.producttalenshow.base.ProductTalenshowTbl;

/**
 * Model class for ProductTalenshow. Add not database mapped fileds in this class.
 */
public class ProductTalenshow extends ProductTalenshowTbl {

  	/**
	 * Default Empty Constructor for class ProductTalenshow
	 */
	public ProductTalenshow () {
		super();
	}
	
	
	/**
	 * 定义实体的业务名取值； productTalenshowName
	 * 必须手工完成这个部分，否则编译不通过。
	 */
	public String getProductTalenshowName () {
		if (this.productTalenShowId == null)
	        return "";
	    else
			//返回一个指定有业务意义的属性值;
			//如：product的VO就用product.productName
	        return this.productTalenShowId+"";
	}
	
	/**
	 * Default Key Fields Constructor for class ProductTalenshow
	 */
	public ProductTalenshow (
		 Integer in_productTalenShowId
		) {
		super (
		  in_productTalenShowId
		);
	}

}
