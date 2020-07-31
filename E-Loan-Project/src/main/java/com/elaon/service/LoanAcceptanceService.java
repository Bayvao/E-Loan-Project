package com.elaon.service;

import java.util.List;

import javax.validation.Valid;

import com.elaon.entity.LoanAcceptance;
import com.elaon.entity.LoanAmortization;
import com.elaon.entity.LoanStatus;
import com.elaon.model.AcceptLoan;
import com.elaon.model.Amortization;

public interface LoanAcceptanceService {


	public Long updateAndAdd(LoanStatus ls, AcceptLoan lAcc, @Valid Amortization loanAmor);

	public void rejectLoan(Long loanId);

	public LoanAcceptance findLoanById(Long loanNumber);
	
	public List<LoanAmortization> getAllLoan();
	
	public List<LoanAmortization> searchByLoanNumber(Long loanNumber);
}