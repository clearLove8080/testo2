//package com.shsxt.service;
//
//import static org.junit.Assert.*;
//
//import java.util.Date;
//import java.util.List;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.github.pagehelper.PageInfo;
//import com.shsxt.query.AccountQuery;
//import com.shsxt.vo.Account;
//
//public class TestAccountService {
//	
//	private AccountService accountService;
//	@Before
//	public void init(){
//		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:spring.xml");
//		accountService=(AccountService) ac.getBean("accountService");
//	
//	}
//
//	
//	@Test
//	public void testAddAccount() {
//		Account account=new Account("sxt01", "0", 100.0, 1, new Date(), new Date(), "sxt01");
//		accountService.insert(account);
//	}
//
//	
//	@Test
//	public void testQueryAccountByParamsForPage(){
//		AccountQuery accountQuery=new AccountQuery();
//		accountQuery.setUserId(1);
//		accountQuery.setPageNum(2);
//		accountQuery.setPageSize(20);
//		PageInfo<Account> pageInfo= accountService.queryForPage(accountQuery);
//		List<Account> accounts=pageInfo.getList();
//		if(null!=accounts&&accounts.size()>0){
//			for(Account account:accounts){
//				System.out.println(account);
//			}
//			
//		}
//		System.out.println("总记录数:"+pageInfo.getTotal()+":总页数:"+pageInfo.getPages());
//	}
//	
//	
//	@Test
//	public void testQueryAccountById() {
//		Account account=accountService.queryById(120);
//		if(null!=account){
//			System.out.println(account);
//		}
//	}
//
//}
