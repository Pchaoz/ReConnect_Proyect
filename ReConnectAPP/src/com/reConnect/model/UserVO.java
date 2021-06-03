package com.reConnect.model;

public class UserVO {
	private int uid;
	private String username;
	private String email;
	private String password;
	private String name;
	private String surname;
	private String imgUrl;
	
	public UserVO() {
		
	}
	
	public UserVO(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	
	public UserVO(String username, String email, String password, String name, String surname) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.imgUrl = "https://www.antiagingya.com/es/wp-content/uploads/2015/01/img-default-autores.jpg";
	}
	
	public UserVO(String username, String email, String password, String name, String surname, String imgUrl) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.imgUrl = imgUrl;
	}
	
	public int getUid() {
		return uid;
	}
	
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getImgUrl() {
		return this.imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
}
