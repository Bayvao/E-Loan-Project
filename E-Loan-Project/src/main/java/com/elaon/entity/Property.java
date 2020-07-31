package com.elaon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "property")
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "property_id")
	private Long propertyId;

	@Column(name = "acres")
	private Long acresOfLand;

	@Column(name = "land_value")
	private Long landValue;

	@Column(name = "produced_on_land")
	private Long producedOnLand;

	@Column(name = "appraised_by")
	private String appraisedBy;

	@Column(name = "valuation_date")
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private String valuationDate;

	@Column(name = "field_representative")
	private String fieldRepresentative;

	@Column(name = "property_country")
	private String country;

	@Column(name = "property_state")
	private String state;

	@OneToOne(mappedBy = "property")
	private Loan loan;

	public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}

	public Long getAcresOfLand() {
		return acresOfLand;
	}

	public void setAcresOfLand(Long acresOfLand) {
		this.acresOfLand = acresOfLand;
	}

	public Long getLandValue() {
		return landValue;
	}

	public void setLandValue(Long landValue) {
		this.landValue = landValue;
	}

	public Long getProducedOnLand() {
		return producedOnLand;
	}

	public void setProducedOnLand(Long producedOnLand) {
		this.producedOnLand = producedOnLand;
	}

	public String getAppraisedBy() {
		return appraisedBy;
	}

	public void setAppraisedBy(String appraisedBy) {
		this.appraisedBy = appraisedBy;
	}

	public String getValuationDate() {
		return valuationDate;
	}

	public void setValuationDate(String valuationDate) {
		this.valuationDate = valuationDate;
	}

	public String getFieldRepresentative() {
		return fieldRepresentative;
	}

	public void setFieldRepresentative(String fieldRepresentative) {
		this.fieldRepresentative = fieldRepresentative;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	@Override
	public String toString() {
		return "Property [propertyId=" + propertyId + ", acresOfLand=" + acresOfLand + ", landValue=" + landValue
				+ ", producedOnLand=" + producedOnLand + ", appraisedBy=" + appraisedBy + ", valuationDate="
				+ valuationDate + ", fieldRepresentative=" + fieldRepresentative + ", country=" + country + ", state="
				+ state + "]";
	}

}