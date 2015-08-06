package com.cartmatic.estore.common.model.talentmanager;

import com.cartmatic.estore.common.model.talentmanager.base.TalentShowTbl;

/**
 * Model class for TalentShow. Add not database mapped fileds in this class.
 */
public class TalentShow extends TalentShowTbl {

  	/**
	 * Default Empty Constructor for class TalentShow
	 */
	public TalentShow () {
		super();
	}
	
	/**
	 * 定义实体的业务名取值； talentShowName
	 * 必须手工完成这个部分，否则编译不通过。
	 */
	public String getTalentShowName () {
		if (talentShowId == null)
	        return "";
	    else
			//返回一个指定有业务意义的属性值;
			//如：product的VO就用product.productName
	        return this.content;
	}
	
	/**
	 * Default Key Fields Constructor for class TalentShow
	 */
	public TalentShow (
		 Integer in_talentShowId
		) {
		super (
		  in_talentShowId
		);
	}

}
