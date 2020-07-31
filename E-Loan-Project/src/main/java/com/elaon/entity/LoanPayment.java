package com.elaon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "loan_payment")
public class LoanPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private Long paymentId;

	@Column(name = "loan_number")
	private Long loanNumber;

	@Column(name = "amount_repaid")
	private Double amountPaid;

	@Column(name = "mode_of_Payment")
	private String modeOfPayment;

	@Column(name = "cheque_or_draft_number")
	private Long chequeOrDraftNumber;

	@Column(name = "date_and_time_of_payment")
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private String dateOfPayment;

	public Long getPaymentId() {
		return paymentId;
	}

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

	@Override
	public String toString() {
		return "LoanPayment [loanNumber=" + loanNumber + ", amountPaid=" + amountPaid + ", modeOfPayment="
				+ modeOfPayment + ", chequeOrDraftNumber=" + chequeOrDraftNumber + ", dateOfPayment=" + dateOfPayment
				+ "]";
	}

}
