package com.shsxt.base;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public class BaseController {
	/**
	 * 只要子类返回视图的方法发生异常  均会执行父类的该方法
	 * @return
	 */
	@ExceptionHandler
	public ModelAndView resolverException(Exception ex){
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
