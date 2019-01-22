package com.cmis.service;

import com.cmis.entity.User;

/**
 * @desc: 测试用注解减少代码臃肿
 * @author yangfei
 * @date 2018年12月13日
 */
public interface TestAnnotationService {
	/**
	 * @desc: 根据Id查询user
	 * @param id
	 * @return  
	 * @author: yangfei
	 * @date: 2018年12月13日
	 */
	User getUserById(String id);
	
}
