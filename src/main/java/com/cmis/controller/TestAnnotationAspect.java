package com.cmis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cmis.entity.User;
import com.cmis.service.TestAnnotationService;

@RestController
public class TestAnnotationAspect {

	@Autowired
	private TestAnnotationService ts;
	
	@RequestMapping("/UserId/{id}")
	public String getUserById(@PathVariable String id) {
		User user = ts.getUserById(id);
		System.out.println(user);
		return "test";
	}
	
	
}
