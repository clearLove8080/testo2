package com.shsxt.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shsxt.base.BaseController;
import com.shsxt.service.TestService;

@Controller
@RequestMapping("test")
public class TestController  extends BaseController{
	
	
	@Resource
	private TestService testService;
	
	@RequestMapping("index")
	public String index() throws Exception{
		testService.test();
		return "test";
	}

}
