package com.elaon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "borrower")
public class Borrower {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "borrower_id")
	private Long borrowerId;

	@Column(name = "borrower_name")
	private String name;

	@Column(name = "business_structure")
	private String businessStructure;

	@Column(name = "billing_indicator")
	private String billingIndicator;

	@Column(name = "tax_indicator")
	private String taxIndicator;

	@Column(name = "borrower_address")
	private String borrowerAddress;

	@Column(name = "borrower_contact_no")
	private String borrowerContactNo;

	@Column(name = "borrower_email")
	private String borrowerEmail;

	@OneToOne(mappedBy = "borrower")
	private Loan loan;

	public Long getBorrowerId() {
		return borrowerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBusinessStructure() {
		return businessStructure;
	}

	public void setBusinessStructure(String businessStructure) {
		this.businessStructure = businessStructure;
	}

	public String getBillingIndicator() {
		return billingIndicator;
	}

	public void setBillingIndicator(String billingIndicator) {
		this.billingIndicator = billingIndicator;
	}

	public String getTaxIndicator() {
		return taxIndicator;
	}

	public void setTaxIndicator(String taxIndicator) {
		this.taxIndicator = taxIndicator;
	}

	public String getBorrowerAddress() {
		return borrowerAddress;
	}

	public void setBorrowerAddress(String borrowerAddress) {
		this.borrowerAddress = borrowerAddress;
	}

	public String getBorrowerContactNo() {
		return borrowerContactNo;
	}

	public void setBorrowerContactNo(String borrowerContactNo) {
		this.borrowerContactNo = borrowerContactNo;
	}

	public String getBorrowerEmail() {
		return borrowerEmail;
	}

	public void setBorrowerEmail(String borrowerEmail) {
		this.borrowerEmail = borrowerEmail;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	@Override
	public String toString() {
		return "Borrower [borrowerId=" + borrowerId + ", name=" + name + ", businessStructure=" + businessStructure
				+ ", billingIndicator=" + billingIndicator + ", taxIndicator=" + taxIndicator + ", borrowerAddress="
				+ borrowerAddress + ", borrowerContactNo=" + borrowerContactNo + ", borrowerEmail=" + borrowerEmail + "]";
	}

}