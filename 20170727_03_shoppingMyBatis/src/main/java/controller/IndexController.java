package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import logic.Item;
import logic.Shop;

public class IndexController implements Controller {
	private Shop shopService;	// Shop 인터페이스가 가지는 기능을 사용하기 위한 인스턴스 멤버
	
	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		List<Item> itemList = shopService.getItemList();
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemList",  itemList);
		
		ModelAndView modelAndView = new ModelAndView();
		// model and view 가 shopService를 붙여서 주면,
		// DispatcherServlet에서는 실제 데이터를 붙인다.
		modelAndView.setViewName("index");
		modelAndView.addAllObjects(model);
		return modelAndView;
	}
}
