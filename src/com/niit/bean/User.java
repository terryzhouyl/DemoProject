package com.niit.bean;

import java.util.Date;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

public class User {

	
	//微信基础信息
    private String nickname;//呢称
    private String openid;//用户唯一标识 
    private Integer sex;//性别:1男,2女,0未知
    private String headimgurl;//头像,有0、46、64、96、132数值可选，0代表640*640正方形头像
	private Integer subscribe;//关注类型 1关注，2取消关注，3重新关注
	private String subscribe_time;//关注时间
    private String language;//语言
    private String country;//国家
    private String province;//省份
    private String city;//城市    
    private Date updateTime;//更新时间
    private Date createTime;//添加用户时间
	private String lat;//经度
	private String lng;//纬度
	//扩展信息
  	private String subscription;//关注描述
  	private String phone;//电话
    private Integer status;//状态 1未删除 2已删除
    
	public Integer getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(Integer subscribe) {
		this.subscribe = subscribe;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String getSubscribe_time() {
		return subscribe_time;
	}
	public void setSubscribe_time(String subscribe_time) {
		this.subscribe_time = subscribe_time;
	}
 
	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSubscription() {
		return subscription;
	}

	public void setSubscription(String subscription) {
		this.subscription = subscription;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Override
	public String toString() {
		return "User [nickname=" + nickname + ", openid=" + openid + ", sex=" + sex + ", headimgurl=" + headimgurl
				+ ", subscribe=" + subscribe + ", subscribe_time=" + subscribe_time + ", language=" + language
				+ ", country=" + country + ", province=" + province + ", city=" + city + ", updateTime=" + updateTime
				+ ", createTime=" + createTime + ", lat=" + lat + ", lng=" + lng + ", subscription=" + subscription
				+ ", phone=" + phone + ", status=" + status + "]";
	}
	
	public int compareTo(User that) {
		return ComparisonChain.start()
				.compare(this.createTime, that.createTime)
				.compare(this.nickname,that.nickname,Ordering.natural().nullsLast())
				.result();
	}
}