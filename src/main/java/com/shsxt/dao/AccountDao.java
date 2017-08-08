package com.shsxt.dao;



import org.apache.ibatis.annotations.Param;

import com.shsxt.base.BaseDao;
import com.shsxt.vo.Account;


public interface AccountDao extends BaseDao<Account>{
	
	/**
	 * 根据账户名称 当前登录用户id  查询账户记录
	 * @param userId
	 * @param aname
	 * @return
	 */
	public Account queryAccountByUserIdAndAname(@Param("userId")int userId,@Param("aname")String aname);
	
	
	
	
	
}


