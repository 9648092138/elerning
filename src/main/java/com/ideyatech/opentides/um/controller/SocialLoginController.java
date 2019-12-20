package com.ideyatech.opentides.um.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideyatech.opentides.um.entity.BaseUser;

@Controller
public class SocialLoginController {
	
	@GetMapping(value="/")
	public String home() {
		return "view/home";
		
	}

	 
}
