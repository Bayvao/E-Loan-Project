package com.elaon.dao;

import org.springframework.data.repository.CrudRepository;

import com.elaon.entity.Loan;

public interface LoanRepository extends CrudRepository<Loan, Long> {

}
