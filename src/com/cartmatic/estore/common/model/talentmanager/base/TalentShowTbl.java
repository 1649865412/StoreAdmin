package com.cartmatic.estore.common.model.talentmanager.base;

import java.io.Serializable;
import com.cartmatic.estore.Constants;
import com.cartmatic.estore.core.model.BaseObject;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * TalentShow Base Java Bean, base class for the model, mapped directly to database table
 * 
 * Avoid changing this file if not necessary, will be overwritten. 
 *
 * TODO: add class/table comments
 */
public class TalentShowTbl extends BaseObject implements Serializable {

    protected Integer talentShowId;
	protected String creatTime;
	protected String content;
	protected java.util.Date releaseTime;
	protected Integer sort;
	protected String img;


	/**
	 * Default Empty Constructor for class TalentShow
	 */
	public TalentShowTbl () {
		super();
	}
	
	/**
	 * Default Key Fields Constructor for class TalentShow
	 */
	public TalentShowTbl (
		 Integer in_talentShowId
        ) {
		this.setTalentShowId(in_talentShowId);
    }

    

	/**
	 * 产品达人秀模块数据自增长ID	 * @return Integer
     * @hibernate.id column="talentShowId" type="java.lang.Integer" generator-class="native"
	 */
	public Integer getTalentShowId() {
		return this.talentShowId;
	}
	
	/**
	 * Set the talentShowId
	 */	
	public void setTalentShowId(Integer aValue) {
		this.talentShowId = aValue;
	}	

	/**
	 * 创建时间	 * @return String
	 * @hibernate.property column="creatTime" type="java.lang.String" length="32" not-null="false" unique="false"
	 */
	public String getCreatTime() {
		return this.creatTime;
	}
	
	/**
	 * Set the creatTime
	 */	
	public void setCreatTime(String aValue) {
		this.creatTime = aValue;
	}	

	/**
	 * 文字内容	 * @return String
	 * @hibernate.property column="content" type="java.lang.String" length="120" not-null="false" unique="false"
	 */
	public String getContent() {
		return this.content;
	}
	
	/**
	 * Set the content
	 */	
	public void setContent(String aValue) {
		this.content = aValue;
	}	

	/**
	 * 发布时间	 * @return java.util.Date
	 * @hibernate.property column="releaseTime" type="java.util.Date" length="0" not-null="false" unique="false"
	 */
	public java.util.Date getReleaseTime() {
		return this.releaseTime;
	}
	
	/**
	 * Set the releaseTime
	 */	
	public void setReleaseTime(java.util.Date aValue) {
		this.releaseTime = aValue;
	}	

	/**
	 * 排序，越大越排前	 * @return Integer
	 * @hibernate.property column="sort" type="java.lang.Integer" length="10" not-null="false" unique="false"
	 */
	public Integer getSort() {
		return this.sort;
	}
	
	/**
	 * Set the sort
	 */	
	public void setSort(Integer aValue) {
		this.sort = aValue;
	}	

	/**
	 * 产品达人秀图片路径	 * @return String
	 * @hibernate.property column="img" type="java.lang.String" length="120" not-null="false" unique="false"
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
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof TalentShowTbl)) {
			return false;
		}
		TalentShowTbl rhs = (TalentShowTbl) object;
		return new EqualsBuilder()
				.append(this.talentShowId, rhs.talentShowId)
				.append(this.creatTime, rhs.creatTime)
				.append(this.content, rhs.content)
				.append(this.releaseTime, rhs.releaseTime)
				.append(this.sort, rhs.sort)
				.append(this.img, rhs.img)
				.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973)
				.append(this.talentShowId) 
				.append(this.creatTime) 
				.append(this.content) 
				.append(this.releaseTime) 
				.append(this.sort) 
				.append(this.img) 
				.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
				.append("talentShowId", this.talentShowId) 
				.append("creatTime", this.creatTime) 
				.append("content", this.content) 
				.append("releaseTime", this.releaseTime) 
				.append("sort", this.sort) 
				.append("img", this.img) 
				.toString();
	}

	/**
	 * Return the name of the first key column
	 */
	public String getFirstKeyColumnName() {
		return "talentShowId";
	}
	
	/**
	 * Return the Id (pk) of the entity, must be Integer
	 */
	public Integer getId() {
		return talentShowId;
	}

}