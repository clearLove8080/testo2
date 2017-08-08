package com.shsxt.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Account implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String aname;
	private String type;
	private Double money;
	private Integer userId;
	
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date createTime;
	
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date updateTime;
	private String remark;
	
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(String aname, String type, Double money, Integer userId,
			Date createTime, Date updateTime, String remark) {
		super();
		this.aname = aname;
		this.type = type;
		this.money = money;
		this.userId = userId;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.remark = remark;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", aname=" + aname + ", type=" + type
				+ ", money=" + money + ", userId=" + userId + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", remark="
				+ remark + "]";
	}
	
	
	

}
