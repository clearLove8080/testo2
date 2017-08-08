package com.shsxt.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.shsxt.base.AssertUtil;
import com.shsxt.base.BaseService;
import com.shsxt.constants.WangCaiConstant;
import com.shsxt.dao.AccountDao;
import com.shsxt.query.AccountQuery;
import com.shsxt.utils.RedisUtil;
import com.shsxt.vo.Account;

@Service
public class AccountService extends BaseService<Account>{
	
	@Resource
	private AccountDao accountDao;
	@Resource
	private RedisUtil redisUtil;

	
	
	
	public void saveOrUpdateAccount(Account account){
		redisUtil.clearKeyByPattern("accounts*");
		/**
		 * 1.参数非空校验
		 *    aname  type   money  userId 
		 * 2.添加 更新
		 *     当前登录用户账户名称不能重复
		 * 3.添加 更新 根据id 值是否存在判断
		 *    id=null   添加
		 *    id!=null  更新
		 */
		checkAccountParams(account);
		account.setUpdateTime(new Date());
		Account temp=accountDao.queryAccountByUserIdAndAname(account.getUserId(), account.getAname());
		if(null==account.getId()){
			/**
			 * 执行重复性校验
			 */
			AssertUtil.isTrue(null!=temp, "账户名称已存在!");
			/**
			 * 执行添加
			 */
			account.setCreateTime(new Date());
			AssertUtil.isTrue(insert(account)<1, "账户记录添加失败!");
		}else{
			/**
			 * 执行重复性校验
			 */
			
			AssertUtil.isTrue(null!=temp&&temp.getId()!=account.getId(), "账户名称已存在!");
			/**
			 * 执行更新
			 */
			AssertUtil.isTrue(update(account)<1, "账户记录更新失败!");
		}
	}
	
	/**
	 * 参数合法性校验
	 * @param account
	 */
	private void checkAccountParams(Account account) {
		AssertUtil.isTrue(StringUtils.isBlank(account.getAname()), "账户名称不能为空!");
		AssertUtil.isTrue(StringUtils.isBlank(account.getType()), "请选择账户类型!");
		AssertUtil.isTrue(null==account.getMoney()||account.getMoney()<=0, "金额非法!");
		AssertUtil.isTrue(null==account.getUserId()||account.getUserId()<=0, "用户非法!");
	}


	public Map<String, Object> queryAccountsByParams(AccountQuery accountQuery){
		Map<String, Object> map=new HashMap<String, Object>();
		String key1="accounts:userId:"+accountQuery.getUserId()+":anme:"+accountQuery.getAname()+":type:"+accountQuery.getType()
				+":time:"+accountQuery.getTime()+":page:"+accountQuery.getPage()+":rows:"+accountQuery.getRows();
		String key2="accounts:userId:"+accountQuery.getUserId()+":anme:"+accountQuery.getAname()+":type:"+accountQuery.getType()
				+":time:"+accountQuery.getTime();
		Object total=redisUtil.getString(key2);	
		if(null!=total&&Integer.parseInt(total.toString())>0){
			map.put("rows", redisUtil.getList(key1));
			map.put("total", Integer.parseInt(total.toString()));
		}
		PageInfo<Account> pageInfo= queryForPage(accountQuery);
		map.put("total", pageInfo.getTotal());
		map.put("rows", pageInfo.getList());
		if(pageInfo.getTotal()>0){
			redisUtil.setString(key2, pageInfo.getTotal());
			redisUtil.setList(key1, pageInfo.getList());
		}
		return map;
 	}	
	
	
	public void deleteAccountBatch(Integer[] ids){
		redisUtil.clearKeyByPattern("accounts*");
		AssertUtil.isTrue(null==ids||ids.length==0, "请选择删除记录!");
		AssertUtil.isTrue(deleteBatch(ids)<1, WangCaiConstant.OPS_FAILED_MSG);
	}
	
}
