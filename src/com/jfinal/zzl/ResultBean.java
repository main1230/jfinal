package com.jfinal.zzl;

public class ResultBean<T> {

	/**
	 * 1成功   2失败
	 */
	private int code = 2;
	private String msg = "操作失败";
	private T data;
	
	
	
	public ResultBean() {
		super();
	}
	public ResultBean(int code, String msg, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
