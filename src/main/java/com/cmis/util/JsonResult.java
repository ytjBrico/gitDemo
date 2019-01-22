package com.cmis.util;

import com.cmis.exceptions.ParamNullException;

public class JsonResult {
	
	//0代表成功，1或者其他代表失败
	private int state;
	//接收返回的数据
	private Object data;
	//定义提示信息
	private String message;
	
	public static final int SUCCESS = 0;
	public static final int ERROR = 1;
	
	public JsonResult() {
		
	}
	
	/**
	 * 区别用户名错误或者密码错误信息提示
	 * @param state
	 * @param e
	 */
	public JsonResult(int state,Throwable e) {
		this.state = state;
		this.data = null;
		this.message = e.getMessage();
	}
	
	/**
	 * 统一的错误提示
	 * @param e
	 */
	public JsonResult(Throwable e) {
		this.state = ERROR;
		this.data = null;
		this.message = e.getMessage();
	}
	
	public JsonResult(int state, Object data, String message) {
		super();
		this.state = state;
		this.data = data;
		this.message = message;
	}

	public JsonResult(Object data) {
		state = SUCCESS;
		this.data = data;
		message = "";
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", data=" + data + ", message=" + message + "]";
	}
	
	
}




