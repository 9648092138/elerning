package com.ideyatech.opentides.um.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ideyatech.opentides.um.entity.BaseUser;

public class SocialLoginController {
	 

	  @GetMapping("/login")
	  public String login(Model model) {

			    return "login";
	  }
}
