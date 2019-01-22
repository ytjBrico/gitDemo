package com.cmis.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cmis.exceptions.ParamNullException;
import com.cmis.util.JsonResult;

@ControllerAdvice
public class BaseController {
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Object exceptionHandle(Exception e) {
		return new JsonResult(e);
	}
	
	@ExceptionHandler(ParamNullException.class)
    Object ExecptionData(ParamNullException e){
        return new JsonResult(e);
       
        //结合thymeleaf模板引擎实现页面跳转
        //ModelAndView modelAndView = new ModelAndView();
        //modelAndView.setViewName("index");
        //modelAndView.addObject("msg", e.getMessage());
        //return modelAndView;

     } 
	
}
