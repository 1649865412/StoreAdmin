package com.cartmatic.estore.common.model.producttalenshow.base;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.cartmatic.estore.common.model.catalog.Product;
import com.cartmatic.estore.common.model.talentmanager.TalentShow;
import com.cartmatic.estore.core.model.BaseObject;

/**
 * ProductTalenshow Base Java Bean, base class for the model, mapped directly to database table
 * 
 * Avoid changing this file if not necessary, will be overwritten. 
 *
 * TODO: add class/table comments
 */
public class ProductTalenshowTbl extends BaseObject implements Serializable {

    protected Integer productTalenShowId;
	protected TalentShow talentShow;
	protected Integer sorted;
	protected Product product;
    

	/**
	 * Default Empty Constructor for class ProductTalenshow
	 */
	public ProductTalenshowTbl () {
		super();
	}
	
	/**
	 * Default Key Fields Constructor for class ProductTalenshow
	 */
	public ProductTalenshowTbl (
		 Integer in_productTalenShowId
        ) {
		this.setProductTalenShowId(in_productTalenShowId);
    }

    

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * 产品与达人秀关系表	 * @return Integer
     * @hibernate.id column="product_talenShow_Id" type="java.lang.Integer" generator-class="native"
	 */
	public Integer getProductTalenShowId() {
		return this.productTalenShowId;
	}
	
	/**
	 * Set the productTalenShowId
	 */	
	public void setProductTalenShowId(Integer aValue) {
		this.productTalenShowId = aValue;
	}	

	public TalentShow getTalentShow() {
		return talentShow;
	}

	public void setTalentShow(TalentShow talentShow) {
		this.talentShow = talentShow;
	}

	/**
	 * 排序ID	 * @return Integer
	 * @hibernate.property column="sorted" type="java.lang.Integer" length="10" not-null="false" unique="false"
	 */
	public Integer getSorted() {
		return this.sorted;
	}
	
	/**
	 * Set the sorted
	 */	
	public void setSorted(Integer aValue) {
		this.sorted = aValue;
	}	

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof ProductTalenshowTbl)) {
			return false;
		}
		ProductTalenshowTbl rhs = (ProductTalenshowTbl) object;
		return new EqualsBuilder()
				.append(this.productTalenShowId, rhs.productTalenShowId)
				.append(this.sorted, rhs.sorted)
				.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973)
				.append(this.productTalenShowId) 
				.append(this.sorted) 
				.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
				.append("productTalenShowId", this.productTalenShowId) 
				.append("sorted", this.sorted) 
				.toString();
	}

	/**
	 * Return the name of the first key column
	 */
	public String getFirstKeyColumnName() {
		return "productTalenShowId";
	}
	
	/**
	 * Return the Id (pk) of the entity, must be Integer
	 */
	public Integer getId() {
		return productTalenShowId;
	}

}