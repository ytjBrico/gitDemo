package com.cmis.util;

import java.security.MessageDigest;
import java.util.UUID;

import org.apache.tomcat.util.codec.binary.Base64;
import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * @desc: 常用工具类 
 * @author yangfei
 * @date 2018年12月13日
 */
public class CommonUtil {
	
	/**
	 * @desc: MD5加密:摘要算法
	 * 		特点:任意长度字节都处理成等长的结果；不可逆；
	 * 		Base64:a-z A-Z 0-9 = +
	 * @param str
	 * @return  
	 * @author: yangfei
	 * @date: 2018年11月14日
	 */
	public static String md5(String str){
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] output = md.digest(str.getBytes());
			String ret = Base64.encodeBase64String(output);
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	/**
	 * @desc: 使用UUID生成Id,
	 * 		此方法没有替换  - ,需要的请自行替换.
	 * @return  
	 * @author: yangfei
	 * @date: 2018年11月14日
	 */
	public static String createId(){
		return UUID.randomUUID().toString();
	}
	
	
	
	
	
	
	
	
	
}




