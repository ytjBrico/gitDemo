package com.cmis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cmis.entity.User;
import com.cmis.service.TestService;
import com.github.pagehelper.PageInfo;

import net.sf.json.JSONArray;

@RestController
public class TestController2 {
	
	private Logger log = LoggerFactory.getLogger(TestController2.class);
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private TestService testService;
	
	@RequestMapping("/test1")
	public ModelAndView TestCon() {
		ModelAndView md = new ModelAndView("user/log_in");
		String str = "APPLY_TO_THE";
		List<Map<String, Object>> testService2 = testService.testService(str);
		for (Map<?,?> m: testService2) {
			log.info(m.toString());
		}
		log.info("====  test1");
		return md;
	}
	
	
	
	@RequestMapping("/test2/{str}")
	public String TestCon2(@PathVariable String str) {
		
		List<Map<String, Object>> testService2 = testService.testService(str);
		for (Map<?,?> m: testService2) {
			log.info(m.toString());
		}
		log.info("====  test2");
		return "test";
	}
	
	@RequestMapping("/queryUser")
	public JSONObject queryUser() {
		String size = request.getParameter("size");
		String page = request.getParameter("page");
		int iSize = -1,
			iPage = -1;
		try {
			iSize = Integer.parseInt(size);
			iPage = Integer.parseInt(page)/iSize + 1;
		} catch (Exception e) {
			//throw new param
		}
		log.info("====queryUser");
		//PageInfo<User> queryUser = testService.queryUser(100, iPage, iSize);
		int num = 100;
		PageInfo<Map<?, ?>> queryUser = testService.queryUserMap(num, iPage, 5);
		JSONObject reMap = new JSONObject();
		reMap.put("total", num);
		reMap.put("rows", JSONArray.fromObject(queryUser.getList()));
		return reMap;
	}
}




