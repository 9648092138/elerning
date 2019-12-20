package com.ideyatech.opentides.um.service;

import org.springframework.social.google.api.plus.Person;

public interface GoogleService {

	String googlelogin();

	String getgoogleaccesstoken(String code);

	Person getgoogleuserprofile(String accessToken);

}
