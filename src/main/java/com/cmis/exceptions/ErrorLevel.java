package com.cmis.exceptions;

/**
 * @desc: 错误级别枚举类
 * @author yangfei
 * @date 2018年11月15日
 */
public enum ErrorLevel {

	FATAL_ERROR,  	 // dec: 系统致命错误
	BUSINESS_ERROR,  // dec: 业务错误
	PARAM_ERROR;	 // dec: 传入参数错误
	
	private ErrorLevel() {}
	
}



