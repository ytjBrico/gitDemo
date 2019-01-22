package com.cmis.aop;

import javax.annotation.Resource;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.cmis.annotation.CacheAndLog;
import com.cmis.cache.CacheService;
import com.cmis.entity.User;
import com.cmis.logs.LogService;
/**
 * @desc: 测试注解缓解项目臃肿
 * @author yangfei
 * @date 2018年12月13日
 */
@Component
@Aspect
public class TestCachAndLogAspect {

	@Resource
	private CacheService cs;
	
	@Resource
	private LogService ls;
	
	//@Around("execution(* com.cmis.service.*.*(..))")		常用拦截点配置.
	//	@Around("@annotation(com.cmis.annotation.CacheAndLog)") //加了这个注解的才拦截
	//需要拿到参数,可以简化写法
	@Around("@annotation(cal)")
	@SuppressWarnings("unused")
	public Object doAround(ProceedingJoinPoint pjp, CacheAndLog cal) {
		Object[] args = pjp.getArgs();
		String key = args[0].toString();
		String cacheName = cal.cacheName();
		boolean needLog = cal.needLog();
		System.out.println("----------1----------");
		/*
		 * 改造成通用方法.
		 */
		//先从缓存中取数据
		Object cacheUser = cs.cacheResult(key, cacheName);
		if (cacheUser != null) {
			return cacheUser;
		}
		//如果缓存没有
		Object reUser = null;
		try {
			pjp.proceed(); //只有这一行是真正的业务代码.
		} catch (Throwable e) {
			//日志也要改成通用的.
			ls.error(pjp.getSourceLocation().getWithinType().toString(),pjp.getSignature().getName(),e);
			//pjp.getSourceLocation().getWithinType() 拿到类名.
			//pjp.getSignature().getName() 拿到唯一的方法名.
		}
		ls.info(pjp.getSourceLocation().getWithinType().toString(),pjp.getSignature().getName(),"successed");
		
		//放入缓存
		if (reUser != null) {
			cs.cachePut(key,reUser,cacheName);
		}
		
		System.out.println("----------2-----------");
		return reUser;
		
		
	}
	
	
}


