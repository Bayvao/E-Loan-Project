package com.elaon.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elaon.model.LoanBorrower;
import com.elaon.model.LoanDetails;
import com.elaon.model.PropertyDetails;
import com.elaon.model.SmsRequest;
import com.elaon.service.MailMessageSender;
import com.elaon.service.NewLoanService;
import com.elaon.service.Service;

@Controller
@RequestMapping("/loan")
public class NewLoanController {

	private final Service smsService;

	@Autowired
	public NewLoanController(Service SmsService) {
		super();
		this.smsService = SmsService;
	}

	@Autowired
	private NewLoanService newLoanService;

	@Autowired
	MailMessageSender mailSender;

	private Logger logger = Logger.getLogger(getClass().getName());

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/showNewCustomerForm")
	public String showNewLoan(Model model) {

		model.addAttribute("loanBorrower", new LoanBorrower());
		return "borrower-details-form";
	}

	@PostMapping("/processBorrower")
	public String showHome(@Valid @ModelAttribute("loanBorrower") LoanBorrower loanBorrower, BindingResult result,
			Model model, HttpSession session) {

		if (result.hasErrors()) {

			return "borrower-details-form";
		}

		String name = loanBorrower.getbName();
		String email = loanBorrower.getbEmail();

		logger.info("Processing Borrower Form for: " + name + " " + email);

		session.setAttribute("loanBorrower", loanBorrower);

		model.addAttribute("propDetails", new PropertyDetails());

		return "property-details-form";
	}

	@PostMapping("/processProperty")
	public String showHome(@Valid @ModelAttribute("propDetails") PropertyDetails propDetails, BindingResult result,
			Model model, HttpSession session) {

		if (result.hasErrors()) {

			return "property-details-form";
		}

		LoanBorrower lb = (LoanBorrower) session.getAttribute("loanBorrower");

		Long acres = propDetails.getAcresLand();
		Long landVal = propDetails.getLandValue();

		logger.info("Processing Borrower Form for: " + lb.getbName() + " " + lb.getbEmail());
		logger.info("Processing property Form for: " + acres + " " + landVal);

		session.setAttribute("propDetails", propDetails);

		model.addAttribute("loanDetails", new LoanDetails());

		return "loan-details-form";
	}

	@PostMapping("/processLoanDetails")
	public String submitForm(@Valid @ModelAttribute("loanDetails") LoanDetails loanDetails, BindingResult result,
			Model model, HttpSession session) {

		if (result.hasErrors()) {

			return "loan-details-form";
		}

		LoanBorrower lb = (LoanBorrower) session.getAttribute("loanBorrower");

		PropertyDetails pd = (PropertyDetails) session.getAttribute("propDetails");

		logger.info("Processing Loan Form for: " + lb.getbEmail() + " " + pd.getAcresLand());

		session.setAttribute("loanDetails", loanDetails);

		Long id = newLoanService.save(lb, pd, loanDetails);
		System.out.println("Congratulations loan saved for " + lb.getbName());

		String number = "+91" + lb.getbContactNo();
		String message = "Loan Application Submitted with application number - " + id;
		String email = lb.getbEmail();
		String subject = "Loan Application Submitted";

		SmsRequest smsRequest = new SmsRequest(number, message, email);

		smsService.sendSms(smsRequest);
		mailSender.sendMail(smsRequest, subject);

		session.removeAttribute("loanBorrower");
		session.removeAttribute("propDetails");
		session.removeAttribute("loanDetails");
		model.addAttribute("id", id);
		return "form-submit-confirmation";
	}

}