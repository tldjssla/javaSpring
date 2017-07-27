package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

import logic.Item;
import logic.Shop;

@Controller
public class DetailController {
	private Shop shopService;
	
	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}
	
	
	// Index의 Handle Request하라고 하는 것
	// Request Mapping이 하나가 아닐 수도 있다.
	// 얘는 method 방식(get/post)을 지정해주지 않았으니
	// doGet이건 doPost이건 detailItem 으로 온다.
	// 참고로 post은 form태그에서 method를 post로 지정해준 것 아니면 없다.
	// 하지만 get방식은, url에 뭔가 하는 것은 모두 get 방식 (href에 하건, url에 직접 입력, ....)
	@RequestMapping
	public ModelAndView detailItem(Integer itemId) {
		Item item = shopService.getItemByItemId(itemId);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("item", item);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("detail");
		modelAndView.addAllObjects(model);
		
		return modelAndView;
	}
}
