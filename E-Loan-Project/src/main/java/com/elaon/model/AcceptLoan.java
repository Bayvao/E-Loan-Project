package com.elaon.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AcceptLoan {

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String regOffice;
	
	private String sancDate;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String sancOffical;
	
	private Long loanId;

	public String getRegOffice() {
		return regOffice;
	}

	public void setRegOffice(String regOffice) {
		this.regOffice = regOffice;
	}

	public String getSancDate() {
		return sancDate;
	}

	public void setSancDate(String sancDate) {
		this.sancDate = sancDate;
	}

	public String getSancOffical() {
		return sancOffical;
	}

	public void setSancOffical(String sancOffical) {
		this.sancOffical = sancOffical;
	}

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

}
