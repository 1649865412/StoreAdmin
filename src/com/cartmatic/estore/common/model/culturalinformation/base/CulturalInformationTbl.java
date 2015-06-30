package com.cartmatic.estore.common.model.culturalinformation.base;

import java.io.Serializable;
import com.cartmatic.estore.Constants;
import com.cartmatic.estore.core.model.BaseObject;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * CulturalInformation Base Java Bean, base class for the model, mapped directly to database table
 * 
 * Avoid changing this file if not necessary, will be overwritten. 
 *
 * TODO: add class/table comments
 */
public class CulturalInformationTbl extends BaseObject implements Serializable {

    protected Integer culturalInformationId;
	protected String title;
	protected String textIntroduction;
	protected Integer commentNumber;
	protected java.util.Date releaseTime;
	protected Integer readNumber;
	protected String writer;
	protected Integer type;
	protected String logoImg;
	protected String imgOne;
	protected String imgTwo;
	protected Integer brandId;
	protected Integer sortOrder;
	protected java.util.Date createTime;
	protected String videoAddress;
	protected String backOne;
	protected String backTwo;
	protected String metaKeywork;
	protected Integer state;

	/**
	 * Default Empty Constructor for class CulturalInformation
	 */
	public CulturalInformationTbl () {
		super();
	}
	
	/**
	 * Default Key Fields Constructor for class CulturalInformation
	 */
	public CulturalInformationTbl (
		 Integer in_culturalInformationId
        ) {
		this.setCulturalInformationId(in_culturalInformationId);
    }

    

	/**
	 * 文化资讯表自增长ID	 * @return Integer
     * @hibernate.id column="culturalInformationId" type="java.lang.Integer" generator-class="native"
	 */
	public Integer getCulturalInformationId() {
		return this.culturalInformationId;
	}
	
	/**
	 * Set the culturalInformationId
	 */	
	public void setCulturalInformationId(Integer aValue) {
		this.culturalInformationId = aValue;
	}	

	/**
	 * 标题	 * @return String
	 * @hibernate.property column="title" type="java.lang.String" length="128" not-null="false" unique="false"
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Set the title
	 */	
	public void setTitle(String aValue) {
		this.title = aValue;
	}	

	/**
	 * 内容	 * @return String
	 * @hibernate.property column="textIntroduction" type="java.lang.String" length="65535" not-null="false" unique="false"
	 */
	public String getTextIntroduction() {
		return this.textIntroduction;
	}
	
	/**
	 * Set the textIntroduction
	 */	
	public void setTextIntroduction(String aValue) {
		this.textIntroduction = aValue;
	}	

	/**
	 * 评论数	 * @return Integer
	 * @hibernate.property column="commentNumber" type="java.lang.Integer" length="10" not-null="false" unique="false"
	 */
	public Integer getCommentNumber() {
		return this.commentNumber;
	}
	
	/**
	 * Set the commentNumber
	 */	
	public void setCommentNumber(Integer aValue) {
		this.commentNumber = aValue;
	}	

	/**
	 * 发布时间	 * @return java.util.Date
	 * @hibernate.property column="releaseTime" type="java.lang.String" length="20" not-null="false" unique="false"
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
	 * 阅读数	 * @return Integer
	 * @hibernate.property column="readNumber" type="java.lang.Integer" length="10" not-null="false" unique="false"
	 */
	public Integer getReadNumber() {
		return this.readNumber;
	}
	
	/**
	 * Set the readNumber
	 */	
	public void setReadNumber(Integer aValue) {
		this.readNumber = aValue;
	}	

	/**
	 * 作者	 * @return String
	 * @hibernate.property column="writer" type="java.lang.String" length="20" not-null="false" unique="false"
	 */
	public String getWriter() {
		return this.writer;
	}
	
	/**
	 * Set the writer
	 */	
	public void setWriter(String aValue) {
		this.writer = aValue;
	}	

	/**
	 * 类型（0：秀场）（1：访谈）（2：行业动态）（3：线下主题活动）	 * @return Integer
	 * @hibernate.property column="type" type="java.lang.Integer" length="10" not-null="false" unique="false"
	 */
	public Integer getType() {
		return this.type;
	}
	
	/**
	 * Set the type
	 */	
	public void setType(Integer aValue) {
		this.type = aValue;
	}	

	/**
	 * logo路径	 * @return String
	 * @hibernate.property column="logoImg" type="java.lang.String" length="128" not-null="false" unique="false"
	 */
	public String getLogoImg() {
		return this.logoImg;
	}
	
	/**
	 * Set the logoImg
	 */	
	public void setLogoImg(String aValue) {
		this.logoImg = aValue;
	}	

	/**
	 * 大图一	 * @return String
	 * @hibernate.property column="imgOne" type="java.lang.String" length="128" not-null="false" unique="false"
	 */
	public String getImgOne() {
		return this.imgOne;
	}
	
	/**
	 * Set the imgOne
	 */	
	public void setImgOne(String aValue) {
		this.imgOne = aValue;
	}	

	/**
	 * 大图二	 * @return String
	 * @hibernate.property column="imgTwo" type="java.lang.String" length="128" not-null="false" unique="false"
	 */
	public String getImgTwo() {
		return this.imgTwo;
	}
	
	/**
	 * Set the imgTwo
	 */	
	public void setImgTwo(String aValue) {
		this.imgTwo = aValue;
	}	

	/**
	 * 品牌ID	 * @return Integer
	 * @hibernate.property column="brandId" type="java.lang.Integer" length="10" not-null="false" unique="false"
	 */
	public Integer getBrandId() {
		return this.brandId;
	}
	
	/**
	 * Set the brandId
	 */	
	public void setBrandId(Integer aValue) {
		this.brandId = aValue;
	}	

	/**
	 * 排序字段（越大越前）	 * @return Integer
	 * @hibernate.property column="sortOrder" type="java.lang.Integer" length="10" not-null="false" unique="false"
	 */
	public Integer getSortOrder() {
		return this.sortOrder;
	}
	
	/**
	 * Set the sortOrder
	 */	
	public void setSortOrder(Integer aValue) {
		this.sortOrder = aValue;
	}	

	/**
	 * 创建时间	 * @return java.util.Date
	 * @hibernate.property column="createTime" type="java.lang.String" length="20" not-null="false" unique="false"
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
	 * 视屏地址（备用）	 * @return String
	 * @hibernate.property column="videoAddress" type="java.lang.String" length="20" not-null="false" unique="false"
	 */
	public String getVideoAddress() {
		return this.videoAddress;
	}
	
	/**
	 * Set the videoAddress
	 */	
	public void setVideoAddress(String aValue) {
		this.videoAddress = aValue;
	}	

	/**
	 * 备用字段一	 * @return String
	 * @hibernate.property column="backOne" type="java.lang.String" length="20" not-null="false" unique="false"
	 */
	public String getBackOne() {
		return this.backOne;
	}
	
	/**
	 * Set the backOne
	 */	
	public void setBackOne(String aValue) {
		this.backOne = aValue;
	}	

	/**
	 * 备用字段二	 * @return String
	 * @hibernate.property column="backTwo" type="java.lang.String" length="20" not-null="false" unique="false"
	 */
	public String getBackTwo() {
		return this.backTwo;
	}
	
	/**
	 * Set the backTwo
	 */	
	public void setBackTwo(String aValue) {
		this.backTwo = aValue;
	}	
	
	
	
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * 搜索关键字字段	 * @return String
	 * @hibernate.property column="backTwo" type="java.lang.String" length="20" not-null="false" unique="false"
	 */
	public String getMetaKeywork() {
		return metaKeywork;
	}

	public void setMetaKeywork(String metaKeywork) {
		this.metaKeywork = metaKeywork;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof CulturalInformationTbl)) {
			return false;
		}
		CulturalInformationTbl rhs = (CulturalInformationTbl) object;
		return new EqualsBuilder()
				.append(this.culturalInformationId, rhs.culturalInformationId)
				.append(this.title, rhs.title)
				.append(this.textIntroduction, rhs.textIntroduction)
				.append(this.commentNumber, rhs.commentNumber)
				.append(this.releaseTime, rhs.releaseTime)
				.append(this.readNumber, rhs.readNumber)
				.append(this.writer, rhs.writer)
				.append(this.type, rhs.type)
				.append(this.logoImg, rhs.logoImg)
				.append(this.imgOne, rhs.imgOne)
				.append(this.imgTwo, rhs.imgTwo)
				.append(this.brandId, rhs.brandId)
				.append(this.sortOrder, rhs.sortOrder)
				.append(this.createTime, rhs.createTime)
				.append(this.videoAddress, rhs.videoAddress)
				.append(this.backOne, rhs.backOne)
				.append(this.backTwo, rhs.backTwo)
				.append(this.state, rhs.state)
				.append(this.metaKeywork, rhs.metaKeywork)
				.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973)
				.append(this.culturalInformationId) 
				.append(this.title) 
				.append(this.textIntroduction) 
				.append(this.commentNumber) 
				.append(this.releaseTime) 
				.append(this.readNumber) 
				.append(this.writer) 
				.append(this.type) 
				.append(this.logoImg) 
				.append(this.imgOne) 
				.append(this.imgTwo) 
				.append(this.brandId) 
				.append(this.sortOrder) 
				.append(this.createTime) 
				.append(this.videoAddress) 
				.append(this.backOne) 
				.append(this.backTwo)
				.append(this.state) 
				.append(this.metaKeywork)
				.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
				.append("culturalInformationId", this.culturalInformationId) 
				.append("title", this.title) 
				.append("textIntroduction", this.textIntroduction) 
				.append("commentNumber", this.commentNumber) 
				.append("releaseTime", this.releaseTime) 
				.append("readNumber", this.readNumber) 
				.append("writer", this.writer) 
				.append("type", this.type) 
				.append("logoImg", this.logoImg) 
				.append("imgOne", this.imgOne) 
				.append("imgTwo", this.imgTwo) 
				.append("brandId", this.brandId) 
				.append("sortOrder", this.sortOrder) 
				.append("createTime", this.createTime) 
				.append("videoAddress", this.videoAddress) 
				.append("backOne", this.backOne) 
				.append("backTwo", this.backTwo) 
				.append("state",this.state) 
				.append(this.metaKeywork)
				.toString();
	}

	/**
	 * Return the name of the first key column
	 */
	public String getFirstKeyColumnName() {
		return "culturalInformationId";
	}
	
	/**
	 * Return the Id (pk) of the entity, must be Integer
	 */
	public Integer getId() {
		return culturalInformationId;
	}

}