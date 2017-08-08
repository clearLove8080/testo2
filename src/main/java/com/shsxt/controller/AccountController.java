package com.shsxt.controller;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.base.ParamsException;
import com.shsxt.constants.WangCaiConstant;
import com.shsxt.model.MessageModel;
import com.shsxt.query.AccountQuery;
import com.shsxt.service.AccountService;
import com.shsxt.vo.Account;

@Controller
@RequestMapping("account")
public class AccountController {
	
	@Resource
	private AccountService accountService;
	
	
	@RequestMapping("index")
	public String index(){
		return "account";
	}
	
	
	@RequestMapping("queryAccountById")
	@ResponseBody
	public Account queryAccountById(int id){
		return accountService.queryById(id);
	}
	
	@ResponseBody
	@RequestMapping("queryAccountsByParams")
	public  Map<String, Object> queryAccountsByParams(AccountQuery accountQuery){
		accountQuery.setUserId(1);
		return accountService.queryAccountsByParams(accountQuery);
	}
	
	
	@RequestMapping("saveOrUpdateAccount")
	@ResponseBody
	public MessageModel saveOrUpdateAccount(Account account){
		MessageModel messageModel=new MessageModel();
		try {
			account.setUserId(1);
			accountService.saveOrUpdateAccount(account);
		} catch (ParamsException e) {
			e.printStackTrace();
			messageModel.setCode(e.getErrorCode());
			messageModel.setMsg(e.getErrorMsg());
		}catch (Exception e) {
			e.printStackTrace();
			messageModel.setCode(WangCaiConstant.OPS_FAILED_CODE);
			messageModel.setMsg(WangCaiConstant.OPS_FAILED_MSG);
		}
		return messageModel;
	}

	
	
	@RequestMapping("deleteAccount")
	@ResponseBody
	public MessageModel deleteAccount(Integer[] ids){
		MessageModel messageModel=new MessageModel();
		try {
			accountService.deleteAccountBatch(ids);
		}catch (ParamsException e) {
			e.printStackTrace();
			messageModel.setCode(e.getErrorCode());
			messageModel.setMsg(e.getErrorMsg());
		}catch (Exception e) {
			e.printStackTrace();
			messageModel.setCode(WangCaiConstant.OPS_FAILED_CODE);
			messageModel.setMsg(WangCaiConstant.OPS_FAILED_MSG);
		}
		return messageModel;
	}
}
