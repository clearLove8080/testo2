package com.shsxt.service;

import org.junit.experimental.theories.Theories;
import org.springframework.stereotype.Service;

import com.shsxt.base.BusinessException;
import com.shsxt.base.ParamsException;

@Service
public class TestService {
	
	
	
	public void test() throws Exception{
		throw new ParamsException("自定义参数异常。。。");
		//throw new BusinessException("自定义业务异常。。。");
		//throw new Exception("默认异常。。。");
	}

}
