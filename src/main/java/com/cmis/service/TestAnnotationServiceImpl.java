package com.cmis.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmis.annotation.CacheAndLog;
import com.cmis.cache.CacheService;
import com.cmis.dao.TestDao;
import com.cmis.entity.User;
import com.cmis.logs.LogService;
/**
 * @desc: 测试用注解来减少代码臃肿
 * -未使用注解的类
 * @author yangfei
 * @date 2018年12月13日
 */
//@Service
public class TestAnnotationServiceImpl /*implements TestAnnotationService*/{

	@Autowired 
	private TestDao testDAo;

	@Resource
	private CacheService cs;
	
	@Resource
	private LogService ls;
	
	private static final String CACHE_NAME = "USER";
	
	/**
	 * -没有使用注解来减少代码雍正的代码
	 */
	@SuppressWarnings("unused")
	//@Override
	public User getUserById(String id) {
		System.out.println("--------00----------");
		//先从缓存中取数据
		User cacheUser = cs.cacheResult(id, CACHE_NAME);
		if (cacheUser != null) {
			return cacheUser;
		}
		//如果缓存没有
		User reUser = null;
		try {
			//reUser = testDAo.getUserById(id); //只有这一行是真正的业务代码.
		} catch (Exception e) {
			ls.error(this.getClass().getSimpleName(),"getUserById",e);
		}
		ls.info(this.getClass().getSimpleName(),"getUserById","successed");
		
		//放入缓存
		if (reUser != null) {
			cs.cachePut(id,reUser,CACHE_NAME);
		}
		
		return reUser;
	}
	

	
	

}
