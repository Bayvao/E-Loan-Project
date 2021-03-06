package com.elaon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "loan_amortization")
public class LoanAmortization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "amortization_id")
	private Long amortizationId;

	@Column(name = "term_of_loan")
	private int termOfLoan;

	@Column(name = "repayment_start_date")
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private String repaymentStartDate;

	@Column(name = "loan_closure_date")
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private String loanClosureDate;

	@Column(name = "interest_rate")
	private Double interestRate;

	@Column(name = "monthly_payment_amount")
	private Double monthlyPaymentAmount;

	@Column(name = "loan_number")
	private Long loanNumber;

	public Long getAmortizationId() {
		return amortizationId;
	}

	public Long getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(Long loanNumber) {
		this.loanNumber = loanNumber;
	}

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

	@Override
	public String toString() {
		return "LoanAmortization [amortizationId=" + amortizationId + ", termOfLoan=" + termOfLoan
				+ ", repaymentStartDate=" + repaymentStartDate + ", loanClosureDate=" + loanClosureDate
				+ ", interestRate=" + interestRate + ", monthlyPaymentAmount=" + monthlyPaymentAmount + ", loanNumber="
				+ loanNumber + "]";
	}

}
