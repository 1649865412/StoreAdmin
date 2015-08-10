package com.cartmatic.estore.common.model.talentmanager;

import net.sf.json.JSONObject;

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
	 * 构建简单的Json对象主要用于选择器
	 * @return
	 */
	public String getJsonObject(){
		JSONObject jsonSupplier=new JSONObject();
		jsonSupplier.put("talentShowId",this.talentShowId);
		jsonSupplier.put("content",this.content);
		jsonSupplier.put("img", this.img);
		jsonSupplier.put("releaseTime", this.releaseTime);
		return jsonSupplier.toString();
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
