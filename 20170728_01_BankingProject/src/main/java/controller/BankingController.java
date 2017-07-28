package controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.Account;
import service.BankService;

public class BankingController {
	private BankService bankService;

	public void setBankService(BankService bankService) {
		this.bankService = bankService;
	}
	
	@ModelAttribute
	public Account setUpForm() {
		return new Account();
	}	
	
	// 입금 요청시, 입금하기 위한 정보를 입력하는 페이지를 반환
	@RequestMapping(value = "/deposit.bk", method = RequestMethod.GET)
	public ModelAndView deposit(Account account) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("main");
		modelAndView.addObject("selPage", "deposit_Form");
		return modelAndView;
	}
	
	// 실제 입금 처리
	@RequestMapping(value = "/depositAction.bk", method = RequestMethod.POST)
	public ModelAndView depositLogic(Account account) {		
		// 1. 먼저 입금할 계좌를 찾는다.
		Account depositAccount = bankService.findAccountByAccNum(account.getAccNum());
		
		// 2. 입금할 계좌 객체가 첫번째 파라미터 (기존 잔액이 있어야 함), 두번째 파라미터는 입금할 금액
		boolean res = bankService.deposit(depositAccount, account.getBalance());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("main");
		
		if(res) {
			// 입금에 성공한 경우, 해당 계좌의 정보를 조회해서 보여준다.
			Account searchedAccount = bankService.findAccountByAccNum(account.getAccNum());
			modelAndView.addObject("account", searchedAccount);
			modelAndView.addObject("selPage", "accInfo");
		} else {
			// 입금에 실패한 경우, 다시 입금 정보를 입력하는 페이지로 이동한다.
			// 그런데 같은 페이지여서 그런지 입력된 값이 그대로 남아있음
			modelAndView.addObject("selPage", "deposit_Form");
		}
		
		return modelAndView;
	}
	
	// 출금 요청시, 출금하기 위한 정보를 입력하는 페이지를 반환
	@RequestMapping(value = "/withdraw.bk", method = RequestMethod.GET)
	public ModelAndView withdraw(Account account) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("main");
		modelAndView.addObject("selPage", "withdraw_Form");
		return modelAndView;
	}
	
	// 실제 출금 처리
	@RequestMapping(value = "/withdrawAction.bk", method = RequestMethod.POST)
	public ModelAndView withdrawLogic(Account account) {
		// 1. 먼저 출금할 계좌를 찾는다.
		Account withdrawAccount = bankService.findAccountByAccNum(account.getAccNum());
		
		// 2. 출금할 계좌 객체가 첫번째 파라미터 (기존 잔액이 있어야 함), 두번째 파라미터는 출금할 금액
		boolean res = bankService.withdraw(withdrawAccount, account.getBalance());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("main");
		
		if(res) {
			// 출금에 성공한 경우, 해당 계좌의 정보를 조회해서 보여준다.
			Account searchedAccount = bankService.findAccountByAccNum(account.getAccNum());
			modelAndView.addObject("account", searchedAccount);
			modelAndView.addObject("selPage", "accInfo");
		} else {
			// 출금에 실패한 경우, 다시 출금 정보를 입력하는 페이지로 이동한다.
			// 그런데 같은 페이지여서 그런지 입력된 값이 그대로 남아있음
			modelAndView.addObject("selPage", "withdraw_Form");
		}
		
		return modelAndView;
	}
}
