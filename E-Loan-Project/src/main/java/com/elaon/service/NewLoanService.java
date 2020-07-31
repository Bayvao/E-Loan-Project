package com.elaon.service;

import com.elaon.model.LoanBorrower;
import com.elaon.model.LoanDetails;
import com.elaon.model.PropertyDetails;

public interface NewLoanService {

	public Long save(LoanBorrower loanBorrower, PropertyDetails propertyDetails, LoanDetails loanDetails);
}
