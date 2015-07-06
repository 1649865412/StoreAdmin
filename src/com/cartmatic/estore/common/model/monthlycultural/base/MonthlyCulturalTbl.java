package com.cartmatic.estore.common.model.monthlycultural.base;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.cartmatic.estore.common.model.culturalinformation.CulturalInformation;
import com.cartmatic.estore.core.model.BaseObject;

/**
 * MonthlyCultural Base Java Bean, base class for the model, mapped directly to database table
 * 
 * Avoid changing this file if not necessary, will be overwritten. 
 *
 * TODO: add class/table comments
 */
public class MonthlyCulturalTbl extends BaseObject implements Serializable {

    protected Integer monthlyCulturalId;
	protected String img;
	protected java.util.Date createTime;
//	protected Integer culturalInformationId;
	protected CulturalInformation culturalInformation;
	

	public CulturalInformation getCulturalInformation() {
		return culturalInformation;
	}

	public void setCulturalInformation(CulturalInformation culturalInformation) {
		this.culturalInformation = culturalInformation;
	}

	/**
	 * Default Empty Constructor for class MonthlyCultural
	 */
	public MonthlyCulturalTbl () {
		super();
	}
	
	/**
	 * Default Key Fields Constructor for class MonthlyCultural
	 */
	public MonthlyCulturalTbl (
		 Integer in_monthlyCulturalId
        ) {
		this.setMonthlyCulturalId(in_monthlyCulturalId);
    }

    

	/**
	 * 文化资讯月刊自增长Id	 * @return Integer
     * @hibernate.id column="monthlyCulturalId" type="java.lang.Integer" generator-class="native"
	 */
	public Integer getMonthlyCulturalId() {
		return this.monthlyCulturalId;
	}
	
	/**
	 * Set the monthlyCulturalId
	 */	
	public void setMonthlyCulturalId(Integer aValue) {
		this.monthlyCulturalId = aValue;
	}	

	/**
	 * 图片链接	 * @return String
	 * @hibernate.property column="img" type="java.lang.String" length="30" not-null="false" unique="false"
	 */
	public String getImg() {
		return this.img;
	}
	
	/**
	 * Set the img
	 */	
	public void setImg(String aValue) {
		this.img = aValue;
	}	

	/**
	 * 发布时间	 * @return java.util.Date
	 * @hibernate.property column="createTime" type="java.util.Date" length="0" not-null="false" unique="false"
	 */
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	/**
	 * Set the createTime
	 */	
	public void setCreateTime(java.util.Date aValue) {
		this.createTime = aValue;
	}	
/*
	*//**
	 * 文化资讯列表Id	 * @return Integer
	 * @hibernate.property column="culturalInformationId" type="java.lang.Integer" length="10" not-null="false" unique="false"
	 *//*
	public Integer getCulturalInformationId() {
		return this.culturalInformationId;
	}
	
	*//**
	 * Set the culturalInformationId
	 *//*	
	public void setCulturalInformationId(Integer aValue) {
		this.culturalInformationId = aValue;
	}*/	

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof MonthlyCulturalTbl)) {
			return false;
		}
		MonthlyCulturalTbl rhs = (MonthlyCulturalTbl) object;
		return new EqualsBuilder()
				.append(this.monthlyCulturalId, rhs.monthlyCulturalId)
				.append(this.img, rhs.img)
				.append(this.createTime, rhs.createTime)
				//.append(this.culturalInformationId, rhs.culturalInformationId)
				.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973)
				.append(this.monthlyCulturalId) 
				.append(this.img) 
				.append(this.createTime) 
				//.append(this.culturalInformationId) 
				.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
				.append("monthlyCulturalId", this.monthlyCulturalId) 
				.append("img", this.img) 
				.append("createTime", this.createTime) 
				//.append("culturalInformationId", this.culturalInformationId) 
				.toString();
	}

	/**
	 * Return the name of the first key column
	 */
	public String getFirstKeyColumnName() {
		return "monthlyCulturalId";
	}
	
	/**
	 * Return the Id (pk) of the entity, must be Integer
	 */
	public Integer getId() {
		return monthlyCulturalId;
	}

}