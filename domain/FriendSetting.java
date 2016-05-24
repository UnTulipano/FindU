package com.iteam.findu.domain;

public class FriendSetting {	
	
	private String id;
	private User user;
	private User friend;
	private boolean isCare;//是否是关心好友
	private double longitude;
	private double latitude;
	private int geoFenceRadiu;//地理围栏半径
	private String alertInfo;//关爱提醒的内容
	private long alertTime;//关爱提醒的时间

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
	public User getFriend() {
		return friend;
	}
	public void setFriend(User friend) {
		this.friend = friend;
	}
	public boolean isCare() {
		return isCare;
	}
	public void setCare(boolean isCare) {
		this.isCare = isCare;
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
	public int getGeoFenceRadiu() {
		return geoFenceRadiu;
	}
	public void setGeoFenceRadiu(int geoFenceRadiu) {
		this.geoFenceRadiu = geoFenceRadiu;
	}
	public String getAlertInfo() {
		return alertInfo;
	}
	public void setAlertInfo(String alertInfo) {
		this.alertInfo = alertInfo;
	}
	public long getAlertTime() {
		return alertTime;
	}
	public void setAlertTime(long alertTime) {
		this.alertTime = alertTime;
	}
	

	public FriendSetting( User user, User friend, boolean isCare,
			double longitude, double latitude, int geoFenceRadiu,
			String alertInfo, long alertTime) {
		super();
	
		this.user = user;
		this.friend = friend;
		this.isCare = isCare;
		this.longitude = longitude;
		this.latitude = latitude;
		this.geoFenceRadiu = geoFenceRadiu;
		this.alertInfo = alertInfo;
		this.alertTime = alertTime;
	}
	@Override
	public String toString() {
		return "FriendSetting [id=" + id + ", user=" + user + ", friend="
				+ friend + ", isCare=" + isCare + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", geoFenceRadiu=" + geoFenceRadiu
				+ ", alertInfo=" + alertInfo + ", alertTime=" + alertTime + "]";
	}
	

}
