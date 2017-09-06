package com.walmart.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="storeDB.deleteStoreByNumber", query="delete from StoreDB obj where obj.strId in(:strNumbers) ")
})
@Entity
@Table(name="Store")
public class StoreDB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="STORE_ID")
	@SequenceGenerator(name="STORE_SEQ", sequenceName="STORE_SEQ", allocationSize=1)
	@GeneratedValue(generator="STORE_SEQ")
	private BigDecimal strId;
	
	@Column(name="STORE_NUMBER")
	private BigDecimal strNumber;
	
	@Column(name="STORE_COUNTRY_CODE")
	private String strCountryCode;
	
	@Column(name="STORE_NAME")
	private String strName;

	public BigDecimal getStrId() {
		return strId;
	}

	public void setStrId(BigDecimal strId) {
		this.strId = strId;
	}

	public BigDecimal getStrNumber() {
		return strNumber;
	}

	public void setStrNumber(BigDecimal strNumber) {
		this.strNumber = strNumber;
	}

	public String getStrCountryCode() {
		return strCountryCode;
	}

	public void setStrCountryCode(String strCountryCode) {
		this.strCountryCode = strCountryCode;
	}

	public String getStrName() {
		return strName;
	}

	public void setStrName(String strName) {
		this.strName = strName;
	}
	
	public void setSampleData(String id){
		this.setStrNumber(BigDecimal.TEN);
		this.setStrCountryCode("MX");
		this.setStrName("Puma");
	}
	
}
