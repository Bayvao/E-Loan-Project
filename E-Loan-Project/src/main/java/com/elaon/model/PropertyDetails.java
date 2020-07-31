package com.elaon.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PropertyDetails {

	@NotNull(message = "is required")
	@Min(value = 1, message = "must be greater than zero")
	private Long acresLand;

	@NotNull(message = "is required")
	@Min(value = 1, message = "must be greater than zero")
	private Long landValue;

	@NotNull(message = "is required")
	@Min(value = 1, message = "must be greater than zero")
	private Long prodOnLand;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String appraisedBy;

	@NotNull(message = "is required")
	private String valDate;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String fieldRepresentative;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String country;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String state;

	public Long getAcresLand() {
		return acresLand;
	}

	public void setAcresLand(Long acresLand) {
		this.acresLand = acresLand;
	}

	public Long getLandValue() {
		return landValue;
	}

	public void setLandValue(Long landValue) {
		this.landValue = landValue;
	}

	public Long getProdOnLand() {
		return prodOnLand;
	}

	public void setProdOnLand(Long prodOnLand) {
		this.prodOnLand = prodOnLand;
	}

	public String getAppraisedBy() {
		return appraisedBy;
	}

	public void setAppraisedBy(String appraisedBy) {
		this.appraisedBy = appraisedBy;
	}

	public String getValDate() {
		return valDate;
	}

	public void setValDate(String valDate) {
		this.valDate = valDate;
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

}
