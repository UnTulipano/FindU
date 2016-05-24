package com.iteam.findu.domain;

public class LocMsg {
	
	private String id;
	private User user;
	private long locDate;
	private double longitude;//经度
	private double latitude;//纬度
	private String addr;//地址
	private int locType;//定位类型   GPS、Wifi
	private double speed;//速度，GPS定位时可用
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getLocDate() {
		return locDate;
	}
	public void setLocDate(long locDate) {
		this.locDate = locDate;
	}
	
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getLocType() {
		return locType;
	}
	public void setLocType(int locType) {
		this.locType = locType;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}


	public LocMsg() {
		super();
	}
	public LocMsg( User user, long locDate, double longitude,
			double latitude, String addr, int locType, double speed) {
		super();
		
		this.user = user;
		this.locDate = locDate;
		this.longitude = longitude;
		this.latitude = latitude;
		this.addr = addr;
		this.locType = locType;
		this.speed = speed;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "LocMsg [id=" + id + ", user=" + user + ", locDate=" + locDate
				+ ", longitude=" + longitude + ", latitude=" + latitude
				+ ", addr=" + addr + ", locType=" + locType + ", speed="
				+ speed + "]";
	}
	

}
