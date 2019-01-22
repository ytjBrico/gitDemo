package com.cmis.logs;

import org.slf4j.Logger;

public interface LogService {
	Logger error(String className,String methodName,Throwable e);
	
	Logger info(String className,String methodName,String info);
}
