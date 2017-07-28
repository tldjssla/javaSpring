package com.lecto.banking;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import model.Account;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@ModelAttribute
	public Account setUpForm() {
		return new Account();
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "main.jsp?selPage=accInfo_Form";
	}*/
	/*
	
	@RequestMapping(value = "/accInfo_Form", method = RequestMethod.GET)
	public String goAccInfoForm() {		
		return "accInfo_Form";
	}
	
	@RequestMapping(value = "/accInfo", method = RequestMethod.GET)
	public String goAccInfo() {		
		return "accInfo";
	}
	
	@RequestMapping(value = "/allAccInfo", method = RequestMethod.GET)
	public String goAllAccInfo() {		
		return "allAccInfo";
	}
	
	@RequestMapping(value = "/login_Form", method = RequestMethod.GET)
	public String goLoginForm() {		
		return "login_Form";
	}
	
	@RequestMapping(value = "/deposit_Form", method = RequestMethod.GET)
	public String goDepositForm() {		
		return "deposit_Form";
	}
	
	@RequestMapping(value = "/makeAccount_Form", method = RequestMethod.GET)
	public String goMakeAccountForm() {		
		return "makeAccount_Form";
	}
	
	@RequestMapping(value = "/top", method = RequestMethod.GET)
	public String goTop() {		
		return "top";
	}
	
	@RequestMapping(value = "/withdraw_Form", method = RequestMethod.GET)
	public String goWithdrawForm() {		
		return "withdraw_Form";
	}*/
}
