package com.zuo.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("outSiteController")
public class OutSiteController {
	
	
	
	@RequestMapping(value={"/index","/",""})
	public String index(){
		
		
		return "outSite/index";
	}

}
