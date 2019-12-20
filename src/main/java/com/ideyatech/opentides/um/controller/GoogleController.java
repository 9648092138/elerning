package com.ideyatech.opentides.um.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.google.api.plus.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.ideyatech.opentides.um.dto.SocialUserInfo;
import com.ideyatech.opentides.um.service.GoogleService;



@Controller
public class GoogleController {

	@Autowired
	private GoogleService googleService;
	
	@GetMapping(value = "/goglelogin")
	public RedirectView googlelogin() {
     RedirectView redirectView = new RedirectView();
     System.out.println("/goglelogin");
     String url = googleService.googlelogin();
     System.out.println(url);
     redirectView.setUrl(url);
     return redirectView;
	}
	
	@GetMapping(value="/google")
	public String google(@RequestParam("code")String code) {
		String accessToken =googleService.getgoogleaccesstoken(code);
		System.out.println("access token"+accessToken);
		return "redirect:/googleprofiledata/"+accessToken;
	}
	
	@GetMapping(value = "/googleprofiledata/{accessToken:.+}")
	public String googleprofiledata(@PathVariable String accessToken,Model model) {
		System.out.println("access token"+accessToken);
		Person user = googleService.getgoogleuserprofile(accessToken);
		System.out.println(""+user.getGivenName()+" "+user.getFamilyName()+" "+user.getImageUrl());
		SocialUserInfo userInfo= new SocialUserInfo(user.getGivenName(),user.getFamilyName(),user.getImageUrl());
	    System.out.println("userinfo"+userInfo);
		model.addAttribute("user",userInfo);
		return "view/userprofile";
	}
}