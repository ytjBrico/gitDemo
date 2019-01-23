package com.cmis.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cmis.service.TestService;

@Controller
public class TestController {
	
	private final Logger log = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private TestService testService;
	
	@RequestMapping("/test3")
	public String TestCon() {
		String str = "APPLY_TO_THE";
		List<Map<String, Object>> testService2 = testService.testService("");
		for (Map<?,?> m: testService2) {
			log.info(m.toString());
		}
		log.info("====  test3");
		return "homePage";
	}
	
	@RequestMapping("/test4")
	public String test4() {
		String str = "APPLY_TO_THE";
		List<Map<String, Object>> testService2 = testService.testService(str);
		for (Map<?,?> m: testService2) {
			log.info(m.toString());
		}
		log.info("====  test4");
		return "starter";
	}
	
	@RequestMapping("/test5")
	public String test5() {
		String str = "APPLY_TO_THE";
		List<Map<String, Object>> testService2 = testService.testService(str);
		for (Map<?,?> m: testService2) {
			log.info(m.toString());
		}
		log.info("====  test5");
		return "homePage2";
	}
	
	@RequestMapping("/test6")
	public String test6() {
		String str = "APPLY_TO_THE";
		List<Map<String, Object>> testService2 = testService.testService(str);
		for (Map<?,?> m: testService2) {
			log.info(m.toString());
		}
		log.info("====  test6");
		return "homePage1";
	}
	
	@RequestMapping("/type")
	public String test7() {
		String str = "学习git 时测试用.";
		String str1 = "这是Master 分支,测试git 分支用.";
		String str1 = "这是dev 分支,测试git 分支用.";
		testService.TestNull();
		return "";
	}
	
}




