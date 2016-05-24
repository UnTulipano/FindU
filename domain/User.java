package com.iteam.findu.domain;

public class User {
	
	private String id;
	private String username;
	private String password;
	private String image;//头像
	private int age;//年龄
	private String tel;//手机号
	private boolean pushSetting;//是否接受推送消息

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Boolean getPushSetting() {
		return pushSetting;
	}
	public void setPushSetting(Boolean pushSetting) {
		this.pushSetting = pushSetting;
	}

	public User() {
		super();
	}

	public User(String username, String password, String image, int age,
			String tel, Boolean pushSetting) {
		super();
		this.username = username;
		this.password = password;
		this.image = image;
		this.age = age;
		this.tel = tel;
		this.pushSetting = pushSetting;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", image=" + image + ", age=" + age + ", tel="
				+ tel + ", pushSetting=" + pushSetting + "]";
	}
	
	

}
