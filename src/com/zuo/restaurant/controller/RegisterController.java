package com.zuo.restaurant.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zuo.restaurant.controller.validation.ValidationGroup2;
import com.zuo.restaurant.po.User;
import com.zuo.restaurant.service.UserService;

@Controller("registerController")
@RequestMapping("/register")
public class RegisterController {
	@Resource
	private UserService userServie;
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public String user(Model model) throws Exception{
		model.addAttribute("user", new User());
		return "register/user";
	}
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String user(Model model,@Validated(value={ValidationGroup2.class}) User user,BindingResult br) throws Exception{
		if(br.hasErrors()){
			List<ObjectError> allErrors=br.getAllErrors();
			for(ObjectError objectError:allErrors){
				System.out.println(objectError.getDefaultMessage());
			}
			model.addAttribute("allErrors", allErrors);
			return "register/user";
		}
		user.setType(1);
		userServie.add(user);
		
		return "/admin/login";
	}
	
//	@RequestMapping(value="/admin",method=RequestMethod.GET)
//	public String admin(Model model) throws Exception{
//		model.addAttribute("user", new User());
//		return "register/admin";
//	}
//	@RequestMapping(value="/admin",method=RequestMethod.POST)
//	public String admin(Model model,@Validated(value={ValidationGroup2.class}) User user,BindingResult br) throws Exception{
//		if(br.hasErrors()){
//			List<ObjectError> allErrors=br.getAllErrors();
//			for(ObjectError objectError:allErrors){
//				System.out.println(objectError.getDefaultMessage());
//			}
//			model.addAttribute("allErrors", allErrors);
//			return "register/admin";
//		}
//		user.setType(0);
//		userServie.add(user);
//		
//		return "login";
//	}
	

}
