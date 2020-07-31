package com.elaon.model;

import javax.validation.constraints.NotNull;

public class Payment {

	@NotNull(message = "required")
	private Long loanNumber;
	@NotNull(message = "required")
	private Double amountPaid;
	@NotNull(message = "required")
	private String modeOfPayment;
	@NotNull(message = "required")
	private Long chequeOrDraftNumber;
	@NotNull(message = "required")
	private String dateOfPayment;

	public Long getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(Long loanNumber) {
		this.loanNumber = loanNumber;
	}

	public Double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public Long getChequeOrDraftNumber() {
		return chequeOrDraftNumber;
	}

	public void setChequeOrDraftNumber(Long chequeOrDraftNumber) {
		this.chequeOrDraftNumber = chequeOrDraftNumber;
	}

	public String getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(String dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

}