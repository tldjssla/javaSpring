package controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.Shop;
import logic.User;

@Controller
public class LoginFormController {
	private Shop shopService;
	private Validator loginValidator;

	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}

	public void setLoginValidator(Validator loginValidator) {
		this.loginValidator = loginValidator;
	}

	// form 태그에서 ModelAttribute annotation을 써주면,
	// 이 메소드를 찾아서 User 객체를 생성하고, 데이터를 셋해준다.
	// 데이터는 form 태그 안에서 input 태그 안에 있는 데이터를 셋하며,
	// 우리가 setter 메소드 호출을 직접하지 않기 때문에 input 태그의 path 속성의 value와 
	// User 객체의 인스턴스 멤버 변수 명이 일치해야 한다.
	@ModelAttribute
	public User setUpForm() {
		return new User(); // 서블릿 내부에서 쓰는게 아니라, login.jsp에서 annotation user를 찾을 때 쓰인다
	}

	@RequestMapping(method = RequestMethod.GET)
	public String toLoginView() {
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView onSubmit(User user, BindingResult bindingResult) {
		// 파라미터로 받은 user객체와, LoginValidator를 binding 시키고, 이 객체를 사용할 때 검사하는 것인지?
		loginValidator.validate(user, bindingResult);

		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.getModel().putAll(bindingResult.getModel());
			// login.jsp가 받는 것
			return modelAndView;
		}
		
		try {
			// loginSuccess.jsp가 받는 것
			User loginUser = shopService.getUserByUserIdAndPassword(user.getUserId(), user.getPassword());
			
			if(loginUser == null) {
				throw new EmptyResultDataAccessException(0);
			}
			
			modelAndView.setViewName("loginSuccess");	// 파일명
			modelAndView.addObject("loginUser",loginUser);
			return modelAndView;

		} catch(EmptyResultDataAccessException e) {
			// 그냥 login.jsp가 받는 것
			bindingResult.reject("error.login.user");
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView;
		}		
	}
}
