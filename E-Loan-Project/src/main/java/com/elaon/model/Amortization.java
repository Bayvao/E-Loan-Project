package com.elaon.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Amortization {

//	@NotNull(message = "is required")
	// @Size(min = 1, message = "is required")
	// private Long loanNumber;

	@NotNull(message = "is required")
	@Min(value = 5, message = "must be greater than zero")
	private int termOfLoan;

	@NotNull(message = "is required")
	private String repaymentStartDate;

	@NotNull(message = "is required")
	private String loanClosureDate;

	@NotNull(message = "is required")
	private Double interestRate;

	@NotNull(message = "is required")
	private Double monthlyPaymentAmount;

	public int getTermOfLoan() {
		return termOfLoan;
	}

	public void setTermOfLoan(int termOfLoan) {
		this.termOfLoan = termOfLoan;
	}

	public String getRepaymentStartDate() {
		return repaymentStartDate;
	}

	public void setRepaymentStartDate(String repaymentStartDate) {
		this.repaymentStartDate = repaymentStartDate;
	}

	public String getLoanClosureDate() {
		return loanClosureDate;
	}

	public void setLoanClosureDate(String loanClosureDate) {
		this.loanClosureDate = loanClosureDate;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public Double getMonthlyPaymentAmount() {
		return monthlyPaymentAmount;
	}

	public void setMonthlyPaymentAmount(Double monthlyPaymentAmount) {
		this.monthlyPaymentAmount = monthlyPaymentAmount;
	}

	/*
	 * public Long getLoanNumber() { return loanNumber; }
	 * 
	 * public void setLoanNumber(Long loanNumber) { this.loanNumber = loanNumber; }
	 */

}
