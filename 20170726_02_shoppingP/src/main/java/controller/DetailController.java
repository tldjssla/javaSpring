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
