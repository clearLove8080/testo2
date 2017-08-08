package com.shsxt.model;

import com.shsxt.constants.WangCaiConstant;

/**
 * 
 * @author lp
 * 业务消息模型
 */
public class MessageModel {
	private Integer code=WangCaiConstant.OPS_SUCCESS_CODE;// 200 成功  300 失败
    private String  msg=WangCaiConstant.OPS_SUCCSSS_MSG;
    
    private Object result;// 存放对象信息
    
    
    
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
    
    
    
	
}
