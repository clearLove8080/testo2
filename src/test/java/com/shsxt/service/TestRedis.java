package com.shsxt.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shsxt.utils.RedisUtil;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml"})
public class TestRedis {
	@Resource
	private RedisUtil redisUtil;
	@Test
	public void test() {
		redisUtil.setString("test", "test1");
	}

	@Test
	public void test1() {
		System.out.println(redisUtil.getString("test"));
	}
}
