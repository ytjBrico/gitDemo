package com.cmis.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

import com.cmis.dao.TestDao;
import com.cmis.entity.User;
import com.cmis.exceptions.ErrorLevel;
import com.cmis.exceptions.ParamNullException;
import com.cmis.exceptions.ResultCodeEnum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import aj.org.objectweb.asm.Type;
@Service
public class TestServiceImpl implements TestService{

	@Autowired 
	private TestDao testDao;
	
	@Override
	public List<Map<String, Object>> testService(String str) {
		if (null == str || "".equals(str))
			throw new ParamNullException(ResultCodeEnum.PARAM_IS_NULL.getCode(), String.format(ResultCodeEnum.PARAM_IS_NULL.getDesc(), "ccccc"), ErrorLevel.PARAM_ERROR);		
		return testDao.testDao(str);
	}

	@Override
	public PageInfo<User> queryUser(int num,int page, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, pageSize);
		List<User> reList = testDao.queryUser(num);
		PageInfo<User> pageList = new PageInfo<>(reList);
		return pageList;
	}

	@Override
	public PageInfo<Map<?, ?>> queryUserMap(int num, int page, int pageSize) {
		PageHelper.startPage(page, pageSize);
		return new PageInfo<>(testDao.queryUserMap(num));
	}

	@Override
	public void TestNull() {
		Map<String, Object> tpye = testDao.getTpye();
		tpye.forEach((k,v) -> System.out.println(k + ": " + v));
	}
	
	

}
