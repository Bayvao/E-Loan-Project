package com.elaon.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elaon.entity.LoanPayment;

public interface LoanPaymentRepository extends CrudRepository<LoanPayment, Long> {

	List<LoanPayment> findAllByLoanNumberOrderByDateOfPaymentDesc(Long loanNumber);

}