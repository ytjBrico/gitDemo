package com.cmis.aop;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
/**
 * @desc: 测试aop
 * @author yangfei
 * @date 2018年12月13日
 */
@Aspect
@Component
public class TimeTestAspect {
	
	private final Logger log = LoggerFactory.getLogger(TimeTestAspect.class);
	
	@Pointcut("execution(* com.cmis.contorller.*.*(..))")
    public void webLog(){}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		log.info( "====进入@Before切面");
		// 接收到请求，记录请求内容 记录 最多半年数据迁移 云备份 nosql 数据库
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		// 记录下请求内容
		log.info("URL : " + request.getRequestURL().toString());
		log.info("HTTP_METHOD : " + request.getMethod());
		log.info("IP : " + request.getRemoteAddr());
		Enumeration<String> enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			log.info("name:{},value:{}", name, request.getParameter(name));
		}
		// 传统写在磁盘上有很大缺点： 分布式情况 服务器集群呢？ 20台服务器，
	}
	
	@Around("execution(* com.cmis.service.TestServiceImpl.*(..))")
	public Object testTime(ProceedingJoinPoint pjp) throws Throwable{
		log.info( "进入Around切面");
		long t1 = System.currentTimeMillis();
		Signature s = pjp.getSignature();
		Object val = pjp.proceed();
		long t2 = System.currentTimeMillis();
		System.out.println(s+":"+(t2-t1));
		return val;
	}
	
	
}
