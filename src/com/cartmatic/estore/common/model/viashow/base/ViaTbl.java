package com.cartmatic.estore.common.model.viashow.base;

import java.io.Serializable;
import com.cartmatic.estore.Constants;
import com.cartmatic.estore.core.model.BaseObject;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * Via Base Java Bean, base class for the model, mapped directly to database table
 * 
 * Avoid changing this file if not necessary, will be overwritten. 
 *
 * TODO: add class/table comments
 */
public class ViaTbl extends BaseObject implements Serializable {

    protected Integer viaId;
	protected String name;
	protected String company;
	protected String email;
	protected String phone;
	protected String bark;


	/**
	 * Default Empty Constructor for class Via
	 */
	public ViaTbl () {
		super();
	}
	
	/**
	 * Default Key Fields Constructor for class Via
	 */
	public ViaTbl (
		 Integer in_viaId
        ) {
		this.setViaId(in_viaId);
    }

    

	/**
	 * 时装周报名表自增长Id	 * @return Integer
     * @hibernate.id column="viaId" type="java.lang.Integer" generator-class="native"
	 */
	public Integer getViaId() {
		return this.viaId;
	}
	
	/**
	 * Set the viaId
	 */	
	public void setViaId(Integer aValue) {
		this.viaId = aValue;
	}	

	/**
	 * 时装周报名姓名	 * @return String
	 * @hibernate.property column="name" type="java.lang.String" length="32" not-null="false" unique="false"
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Set the name
	 */	
	public void setName(String aValue) {
		this.name = aValue;
	}	

	/**
	 * 时装周公司名	 * @return String
	 * @hibernate.property column="company" type="java.lang.String" length="32" not-null="false" unique="false"
	 */
	public String getCompany() {
		return this.company;
	}
	
	/**
	 * Set the company
	 */	
	public void setCompany(String aValue) {
		this.company = aValue;
	}	

	/**
	 * 时装周报名邮箱	 * @return String
	 * @hibernate.property column="email" type="java.lang.String" length="32" not-null="false" unique="false"
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Set the email
	 */	
	public void setEmail(String aValue) {
		this.email = aValue;
	}	

	/**
	 * 电话	 * @return String
	 * @hibernate.property column="phone" type="java.lang.String" length="32" not-null="false" unique="false"
	 */
	public String getPhone() {
		return this.phone;
	}
	
	/**
	 * Set the phone
	 */	
	public void setPhone(String aValue) {
		this.phone = aValue;
	}	

	/**
	 * 备注	 * @return String
	 * @hibernate.property column="bark" type="java.lang.String" length="32" not-null="false" unique="false"
	 */
	public String getBark() {
		return this.bark;
	}
	
	/**
	 * Set the bark
	 */	
	public void setBark(String aValue) {
		this.bark = aValue;
	}	

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof ViaTbl)) {
			return false;
		}
		ViaTbl rhs = (ViaTbl) object;
		return new EqualsBuilder()
				.append(this.viaId, rhs.viaId)
				.append(this.name, rhs.name)
				.append(this.company, rhs.company)
				.append(this.email, rhs.email)
				.append(this.phone, rhs.phone)
				.append(this.bark, rhs.bark)
				.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973)
				.append(this.viaId) 
				.append(this.name) 
				.append(this.company) 
				.append(this.email) 
				.append(this.phone) 
				.append(this.bark) 
				.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
				.append("viaId", this.viaId) 
				.append("name", this.name) 
				.append("company", this.company) 
				.append("email", this.email) 
				.append("phone", this.phone) 
				.append("bark", this.bark) 
				.toString();
	}

	/**
	 * Return the name of the first key column
	 */
	public String getFirstKeyColumnName() {
		return "viaId";
	}
	
	/**
	 * Return the Id (pk) of the entity, must be Integer
	 */
	public Integer getId() {
		return viaId;
	}

}