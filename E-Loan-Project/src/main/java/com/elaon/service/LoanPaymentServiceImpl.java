package com.elaon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elaon.dao.LoanAcceptanceRepository;
import com.elaon.dao.LoanPaymentRepository;
import com.elaon.entity.LoanPayment;
import com.elaon.model.Payment;

@Service
public class LoanPaymentServiceImpl implements LoanPaymentService {

	@Autowired
	LoanPaymentRepository lpr;

	@Autowired
	LoanAcceptanceRepository lar;

	@Override
	public void addPayment(Payment payment) {

		LoanPayment loanPayment = new LoanPayment();
		loanPayment.setLoanNumber(payment.getLoanNumber());
		loanPayment.setAmountPaid(payment.getAmountPaid());
		loanPayment.setModeOfPayment(payment.getModeOfPayment());
		loanPayment.setDateOfPayment(payment.getDateOfPayment());
		loanPayment.setChequeOrDraftNumber(payment.getChequeOrDraftNumber());

		lpr.save(loanPayment);
	}

	@Override
	public boolean loanNumberExist(Long loanNumber) {

		boolean exists = lar.existsById(loanNumber);

		return exists;
	}

	@Override
	public List<LoanPayment> findPaymentByLoanNumber(Long loanNumber) {

		List<LoanPayment> listPayment;
		listPayment = (List<LoanPayment>) lpr.findAllByLoanNumberOrderByDateOfPaymentDesc(loanNumber);

		return listPayment;
	}

}
