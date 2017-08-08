package com.shsxt.base;

/**
 * 业务异常定义-运行期异常
 * @author lp
 *
 */
public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5252844916620478699L;
	
	
	private Integer errorCode=300;
	private String errorMsg="操作失败!";
	
	
	
	public BusinessException(String errorMsg) {
		super(errorMsg);
		this.errorMsg = errorMsg;
	}
	
	
	
	public BusinessException(Integer errorCode) {
		super("操作失败!");
		this.errorCode = errorCode;
	}
	
	

	


	public BusinessException() {
		super("操作失败!");
	}



	public BusinessException(Integer errorCode, String errorMsg) {
		super(errorMsg);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}



	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	

}
