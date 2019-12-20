package com.ideyatech.opentides.um.dto;

public class SocialUserInfo {
private String first_name;
private String last_name;
private String  img_Url;



public SocialUserInfo() {
	super();
}
public SocialUserInfo(String first_name, String last_name, String img_Url) {
	super();
	this.first_name = first_name;
	this.last_name = last_name;
	this.img_Url = img_Url;
}
public String getFirst_name() {
	return first_name;
}
public void setFirst_name(String first_name) {
	this.first_name = first_name;
}
public String getLast_name() {
	return last_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
}
public String getImg_Url() {
	return img_Url;
}
public void setImg_Url(String img_Url) {
	this.img_Url = img_Url;
}

}
