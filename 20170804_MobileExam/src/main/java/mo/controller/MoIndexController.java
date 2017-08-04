package mo.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lectopia.mobile.HomeController;

import model.Account;

public class MoIndexController {
	@ModelAttribute
	public Account setUpForm() {
		return new Account();
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/index.mo", method = RequestMethod.GET)
	public String homeByNoParameter(Locale locale, Model model) {		
		return "moviews/main";
	}
}
