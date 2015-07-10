package com.cartmatic.estore.common.model.branddynamic.base;

import java.io.Serializable;
import com.cartmatic.estore.Constants;
import com.cartmatic.estore.core.model.BaseObject;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * BrandDynamic Base Java Bean, base class for the model, mapped directly to database table
 * 
 * Avoid changing this file if not necessary, will be overwritten. 
 *
 * TODO: add class/table comments
 */
public class BrandDynamicTbl extends BaseObject implements Serializable {

    protected Integer brandDynamicId;
	protected String img;
	protected String content;
	protected String resource;
	protected String website;
	protected String resourceTime;
	protected java.util.Date createTime;
	protected com.cartmatic.estore.common.model.catalog.Brand brand;


	/**
	 * Default Empty Constructor for class BrandDynamic
	 */
	public BrandDynamicTbl () {
		super();
	}
	
	/**
	 * Default Key Fields Constructor for class BrandDynamic
	 */
	public BrandDynamicTbl (
		 Integer in_brandDynamicId
        ) {
		this.setBrandDynamicId(in_brandDynamicId);
    }

	
	public com.cartmatic.estore.common.model.catalog.Brand getBrand () {
		return brand;
	}	
	
	public void setBrand (com.cartmatic.estore.common.model.catalog.Brand in_brand) {
		this.brand = in_brand;
	}
    

	/**
	 * 动态表自增长ID	 * @return Integer
     * @hibernate.id column="brandDynamicId" type="java.lang.Integer" generator-class="native"
	 */
	public Integer getBrandDynamicId() {
		return this.brandDynamicId;
	}
	
	/**
	 * Set the brandDynamicId
	 */	
	public void setBrandDynamicId(Integer aValue) {
		this.brandDynamicId = aValue;
	}	

	/**
	 * 图片url	 * @return String
	 * @hibernate.property column="img" type="java.lang.String" length="255" not-null="false" unique="false"
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
	 * 来源	 * @return String
	 * @hibernate.property column="resource" type="java.lang.String" length="255" not-null="false" unique="false"
	 */
	public String getResource() {
		return this.resource;
	}
	
	/**
	 * Set the resource
	 */	
	public void setResource(String aValue) {
		this.resource = aValue;
	}	

	/**
	 * 网址	 * @return String
	 * @hibernate.property column="website" type="java.lang.String" length="255" not-null="false" unique="false"
	 */
	public String getWebsite() {
		return this.website;
	}
	
	/**
	 * Set the website
	 */	
	public void setWebsite(String aValue) {
		this.website = aValue;
	}	



	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getResourceTime() {
		return resourceTime;
	}

	public void setResourceTime(String resourceTime) {
		this.resourceTime = resourceTime;
	}

	/**
	 * 创建时间	 * @return java.util.Date
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

	/**
	 * 品牌Id	 * @return Integer
	 */
	public Integer getBrandId() {
		return this.getBrand()==null?null:this.getBrand().getBrandId();
	}
	
	/**
	 * Set the brandId
	 */	
	public void setBrandId(Integer aValue) {
	    if (aValue==null) {
	    	brand = null;
	    } else {
	        brand = new com.cartmatic.estore.common.model.catalog.Brand(aValue);
	        brand.setVersion(new Integer(0));//set a version to cheat hibernate only
	    }
	}	

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof BrandDynamicTbl)) {
			return false;
		}
		BrandDynamicTbl rhs = (BrandDynamicTbl) object;
		return new EqualsBuilder()
				.append(this.brandDynamicId, rhs.brandDynamicId)
				.append(this.img, rhs.img)
				.append(this.content, rhs.content)
				.append(this.resource, rhs.resource)
				.append(this.website, rhs.website)
				.append(this.resourceTime, rhs.resourceTime)
				.append(this.createTime, rhs.createTime)
						.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973)
				.append(this.brandDynamicId) 
				.append(this.img) 
				.append(this.content) 
				.append(this.resource) 
				.append(this.website) 
				.append(this.resourceTime) 
				.append(this.createTime) 
						.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
				.append("brandDynamicId", this.brandDynamicId) 
				.append("img", this.img) 
				.append("content", this.content) 
				.append("resource", this.resource) 
				.append("website", this.website) 
				.append("resourceTime", this.resourceTime) 
				.append("createTime", this.createTime) 
						.toString();
	}

	/**
	 * Return the name of the first key column
	 */
	public String getFirstKeyColumnName() {
		return "brandDynamicId";
	}
	
	/**
	 * Return the Id (pk) of the entity, must be Integer
	 */
	public Integer getId() {
		return brandDynamicId;
	}

}