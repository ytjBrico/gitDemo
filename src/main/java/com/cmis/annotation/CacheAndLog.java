package com.cmis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @desc: 用注解的方式开发.
 * -减少代码臃肿
 * -此注释主要用于是否从缓存取数据,是否添加到缓存.
 * -还有是否要记录日志.
 * @author yangfei
 * @date 2018年12月13日
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface CacheAndLog {
	
	//@desc方法需要传入的参数.
	String key();
	
	//@desc存取缓存的key值.
	String cacheName();
	
	//@desc是否要记录日志.
	boolean needLog() default false; 
	
	
}









