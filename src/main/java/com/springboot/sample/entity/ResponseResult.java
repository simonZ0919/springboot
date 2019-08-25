package com.springboot.sample.entity;

import java.io.Serializable;

public class ResponseResult implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3418970632348349928L;
	private Integer state=1;
	private String message;
	
	public ResponseResult() {
		super();
	}	
	
	public ResponseResult(Integer state) {
		super();
		this.state = state;
	}
	
	public ResponseResult(Integer state, String message) {
		super();
		this.state = state;
		this.message = message;
	}
	
	public ResponseResult(Integer state, Exception e) {
		super();
		this.state = state;
		this.message = e.getMessage();
	}


	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ResponseResult [state=" + state + ", message=" + message + "]";
	}
	
}
