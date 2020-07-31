package com.elaon.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.elaon.entity.LoanStatus;

public interface LoanStatusRepository extends CrudRepository<LoanStatus, Long> {

	@Query(value="select * from loan_status ls, loan l where approval_status=:status and ls.lid=l.loan_id", nativeQuery=true)
	List<LoanStatus> getLoanStatusByApprovalStatus(String status);
	
	@Modifying
	@Query(value="UPDATE LoanStatus ls SET ls.approvalStatus = :status WHERE ls.statusId = :id")
	int updateLoanStatus(@Param("status") String status, @Param("id") Long id);
	
}
