package com.shsxt.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

//@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		ModelAndView modelAndView=new ModelAndView("error");
		modelAndView.addObject("ex","服务器错误!");
		modelAndView.addObject("code", 300);
		if(ex instanceof ParamsException){
			ParamsException pe=(ParamsException) ex;
			modelAndView.addObject("ex", pe.getErrorMsg());
			modelAndView.addObject("code", pe.getErrorCode());
			modelAndView.setViewName("params_error");
		}
		
		if(ex instanceof BusinessException){
			BusinessException be=(BusinessException) ex;
			modelAndView.addObject("ex", be.getErrorMsg());
			modelAndView.addObject("code", be.getErrorCode());
			modelAndView.setViewName("business_error");
		}
		return modelAndView;
	}

}
