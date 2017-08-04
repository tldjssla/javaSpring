package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.Account;
import service.BankService;

@Controller
public class AccountController {
	private BankService bankService;

	public void setBankService(BankService bankService) {
		this.bankService = bankService;
	}
	
	// form 태그에서 ModelAttribute annotation을 써주면,
	// 이 메소드를 찾아서 User 객체를 생성하고, 데이터를 셋해준다.
	// 데이터는 form 태그 안에서 input 태그 안에 있는 데이터를 셋하며,
	// 우리가 setter 메소드 호출을 직접하지 않기 때문에 input 태그의 path 속성의 value와 
	// User 객체의 인스턴스 멤버 변수 명이 일치해야 한다.
	// 참고로, Account 객체에 있는 인스턴스 멤버에 대해서, <input 태그의 path가 없다면
	// 그냥 setter 메소드 호출하지 않고 null (혹은 0)인 상태가 된다.
	@ModelAttribute
	public Account setUpForm() {
		return new Account();
	}
	
	
	// Index의 Handle Request하라고 하는 것
	// Request Mapping이 하나가 아닐 수도 있다.
	// 얘는 method 방식(get/post)을 지정해주지 않았으니
	// doGet이건 doPost이건 detailItem 으로 온다.
	// 참고로 post은 form태그에서 method를 post로 지정해준 것 아니면 없다.
	// 하지만 get방식은, url에 뭔가 하는 것은 모두 get 방식 (href에 하건, url에 직접 입력, ....)
	// 계좌개설 요청시, 정보입력을 우선 받아야 한다.
	@RequestMapping(value = "/makeAccount.bk", method = RequestMethod.GET)
	public ModelAndView makeAccount(Account account) {
		// 이 파라미터는 어디서 set이 되서 들어오는 건지?
		// 아까 설명할 때, 파라미터 어떻게 하면 된다고 말씀하셨는데, 
		// 이까지 진행하지 못한 상황이여서 제대로 듣지 못했음
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("main");
		// get방식일 경우 우선 개설할 계좌 정보를 입력받는 페이지를 보여준다.
		
		modelAndView.addObject("selPage", "makeAccount_Form");
		return modelAndView;
	}
	// 계좌정보 입력 후, 실제 계좌를 개설하는 메소드. POST 방식으로 받는다.
	@RequestMapping(value = "/makeAccountAction.bk", method = RequestMethod.POST)
	public ModelAndView makeAccountLogic(Account account) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("main");
		
		// 계좌 개설
		bankService.makeAccount(account);
		
		// 개설 후 다시 전체목록 보여주기 위해 서비스 호출
		List<Account> accountList = bankService.findAccountList();
		modelAndView.addObject("accountList", accountList);
		
		System.out.println(account);
		
		modelAndView.addObject("selPage", "allAccInfo");
		return modelAndView;
	}
	
	
	// 계좌 하나 조회
	// 우선 조회할 계좌의 계좌번호를 입력받는다. (GET)
	@RequestMapping(value = "/searchAccount.bk", method = RequestMethod.GET)
	public ModelAndView searchAccount(Account account) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("main");
		modelAndView.addObject("selPage", "accInfo_Form");
		
		return modelAndView;
	}
	
	// 실제 계좌를 조회
	@RequestMapping(value = "/accInfoAction.bk", method = RequestMethod.POST)
	public ModelAndView searchAccountLogic(Account account) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("main");
		
		Account searchRes = bankService.findAccountByAccNum(account.getAccNum());
		
		if(searchRes!=null) {
			// 찾은 결과를 set Attribute 해준다.
			// 원래는 이렇게 찾는 결과가 없으면 에러 메시지를 출력해 주어야함
			// 20170728_01_BankingProject  프로젝트에 LoginFormController 참조
			modelAndView.addObject("account", searchRes);
		}
		
		// 결과 페이지는 정해야 함
		modelAndView.addObject("selPage", "accInfo");
		
		return modelAndView;
	}
	
	
	// 계좌 전체 정보 조회. 얘는 또 입력받을 필요없이 모두 보여주면 되니까 바로 service 호출 후,
	// 결과값을 addObject 해 준다.
	@RequestMapping(value = "/searchAllAccount.bk", method = RequestMethod.GET)
	public ModelAndView searchAllAccount(Account account) {
		
		List<Account> accountList = bankService.findAccountList();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("main");
		modelAndView.addObject("accountList", accountList);
		modelAndView.addObject("selPage", "allAccInfo");
		
		return modelAndView;
	}
}












