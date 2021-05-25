package com.reConnect.model;

import java.util.Date;

public class PostVO {
	private String title;
	private String message;
	private Date date;
	private int pid;
	private int uid;
	
	public PostVO() {
		
	}
	
	public PostVO(String title, String message, Date date) {
		this.title = title;
		this.message = message;
		this.date = date;
	}
	
	public PostVO(String title, String message, Date date, int pid, int uid) {
		this.title = title;
		this.message = message;
		this.date = date;
		this.pid = pid;
		this.uid = uid;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getPid() {
		return pid;
	}
	
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public int getUid() {
		return uid;
	}
	
	public void setUid(int uid) {
		this.uid = uid;
	}
}
