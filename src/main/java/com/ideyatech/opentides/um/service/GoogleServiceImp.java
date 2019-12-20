package com.ideyatech.opentides.um.service;

import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.impl.GoogleTemplate;
import org.springframework.social.google.api.plus.Person;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;

import com.google.api.client.util.Value;

@Service
public class GoogleServiceImp implements GoogleService {

	//@Value("${google.webclient.id}")
	private String googleId = "924276841181-g17p0hkld49k5i4fcfpeiu9t909nk4vl.apps.googleusercontent.com";
	//@Value("${google.oauthclient.id}")
	private String GoogleSecret="p3v7y5exR-OwG6jURly4wqgr";
	
	
	private GoogleConnectionFactory creategoogleconnection(){
		return new GoogleConnectionFactory(googleId, GoogleSecret);
		
	}


	@Override
	public String googlelogin() {
		// TODO Auto-generated method stub
		
		OAuth2Parameters parameters = new OAuth2Parameters();
		parameters.setRedirectUri("http://localhost:8080/google");
		parameters.setScope("profile");
		creategoogleconnection();
//		parameters.add("clientId", googleId);
//		parameters.add("clientSecret",GoogleSecret);

		return creategoogleconnection().getOAuthOperations().buildAuthenticateUrl(parameters);
	}


	@Override
	public String getgoogleaccesstoken(String code) {
		// TODO Auto-generated method stub
		return creategoogleconnection().getOAuthOperations().exchangeForAccess(code,"http://localhost:8080/google",null).getAccessToken();
	}


	@Override
	public Person getgoogleuserprofile(String accessToken) {
		Google google = new GoogleTemplate(accessToken);
		Person person = google.plusOperations().getGoogleProfile();
		
		return person;
	}
}
