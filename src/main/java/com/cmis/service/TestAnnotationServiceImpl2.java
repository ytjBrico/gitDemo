package com.cmis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cmis.annotation.CacheAndLog;
import com.cmis.dao.TestDao;
import com.cmis.entity.User;
/**
 * @desc: 测试用注解来减少代码臃肿
 * -使用注解的类
 * @author yangfei
 * @date 2018年12月13日
 */
@Service
public class TestAnnotationServiceImpl2 implements TestAnnotationService{

	@Autowired 
	private TestDao testDAo;

	private static final String CACHE_NAME = "USER";
	/**
	 * -使用注解来减少代码臃肿的代码
	 * -把注解注入进来
	 */
	@Override
	@CacheAndLog(key="{id}",cacheName=CACHE_NAME,needLog=true)
	public User getUserById(String id) {
		System.out.println("--------01----------");
		System.out.println("====" + id);
		return testDAo.getUserById(id);	//只有这一行是真正的业务代码.
	}
	

	
	

}
