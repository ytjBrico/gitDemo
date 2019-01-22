package com.cmis.logs;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

	@Override
	public Logger error(String className, String methodName, Throwable e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Logger info(String className, String methodName, String info) {
		// TODO Auto-generated method stub
		return null;
	}

}
