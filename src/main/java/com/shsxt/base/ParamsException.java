package com.shsxt.base;

/**
 * 参数异常定义-运行期异常
 * @author lp
 *
 */
public class ParamsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5252844916620478699L;
	
	
	private Integer errorCode=300;
	private String errorMsg="操作失败!";
	
	
	
	public ParamsException(String errorMsg) {
		super(errorMsg);
		this.errorMsg = errorMsg;
	}
	
	
	
	public ParamsException(Integer errorCode) {
		super("操作失败!");
		this.errorCode = errorCode;
	}
	
	

	


	public ParamsException() {
		super("操作失败!");
	}



	public ParamsException(Integer errorCode, String errorMsg) {
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
