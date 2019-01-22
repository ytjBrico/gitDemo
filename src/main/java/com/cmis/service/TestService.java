package com.cmis.service;

import java.util.List;
import java.util.Map;

import com.cmis.entity.User;
import com.github.pagehelper.PageInfo;

public interface TestService {
	
	List<Map<String,Object>> testService(String str);
	
	PageInfo<User> queryUser(int num,int page, int pageSize);
	PageInfo<Map<?, ?>> queryUserMap(int num,int page, int pageSize);
	
	// 测试 数据库那个字段为空, 是null 还是空字符串.
	void TestNull();
	
}
