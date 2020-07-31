package com.elaon.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.elaon.entity.LoanAmortization;

public interface LoanAmortizationRepository extends CrudRepository<LoanAmortization, Long> {

	@Query(value="select * from loan_amortization where loan_number like %:loanNumber%", nativeQuery=true)
	List<LoanAmortization> searchByLoanNumberContaining(@Param("loanNumber") Long loanNumber);
}
