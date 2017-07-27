package util;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import logic.User;

public class LoginValidator implements Validator {
	@Override
	public boolean supports(Class<?> arg0) {
		return User.class.isAssignableFrom(arg0);	// 검증대상 클래스가 User 클래스임을 명시
	}

	@Override
	public void validate(Object command, Errors errors) {
		User user = (User)command;
		if(!StringUtils.hasLength(user.getUserId())) {
			// 아이디를 입력하지 않고 로그인 요청을 한 경우
			errors.rejectValue("userId", "error.required");
		}
		
		if(!StringUtils.hasLength(user.getPassword())) {
			// 패스워드를 입력하지 않고 로그인 요청을 한 경우
			errors.rejectValue("password", "error.required");
		}
		
		// 에러가 하나라도 발생했으면 이 메시지를 무조건 띄운다는 것
		if(errors.hasErrors()) {
			errors.reject("error.input.user");
		}		
	}

}
