package com.cmis.exceptions;

/**
 * @desc: 参数为空异常类.
 * @author yangfei
 * @date 2018年11月14日
 */
public class ParamNullException extends RuntimeException{

	private static final long serialVersionUID = -8522046053599586399L;

	private String code;
	private String message;
	private ErrorLevel errorLevel;
	
	public ParamNullException(String code, String message, ErrorLevel errorLevel) {
		super();
		this.code = code;
		this.message = message;
		this.errorLevel = errorLevel;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ErrorLevel getErrorLevel() {
		return errorLevel;
	}
	public void setErrorLevel(ErrorLevel errorLevel) {
		this.errorLevel = errorLevel;
	}
	
	
	
	
	
	
}




