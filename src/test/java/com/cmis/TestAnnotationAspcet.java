package com.cmis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cmis.entity.User;
import com.cmis.service.TestAnnotationService;

public class TestAnnotationAspcet {

	@Autowired
	private TestAnnotationService ts;
	
	@SuppressWarnings("unused")
	@Test
	public void getUserById() {
		User user = ts.getUserById("125065997");
		System.out.println("-----------3----------");
	}
	
	
}
