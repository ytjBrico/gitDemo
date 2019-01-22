package com.cmis.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmis.controller.TestController;

@Controller
public class UserController {
	private final Logger log = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping("/index")
	public String loginPage() {
		
		log.info("====loginPage");
		
		return "homePage1";
	}
	
	
	
	
	
}




