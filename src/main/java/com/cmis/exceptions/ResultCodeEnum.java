package com.cmis.exceptions;

/**
 * @desc: 返回码
 * @author yangfei
 * @date 2018年11月15日
 */
public enum ResultCodeEnum {

	SUCCESS("0000", "成功"),
	PARAM_IS_NULL("9100","参数不能为空:%s"),
	
	
	
	FAIL("9999", "内部系统异常"); 
	
	private String code;
	private String desc;
	
	private ResultCodeEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
	
	
	
}



