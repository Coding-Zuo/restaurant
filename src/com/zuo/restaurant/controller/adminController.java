package com.zuo.restaurant.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zuo.restaurant.exception.CustomException;
import com.zuo.restaurant.po.User;
import com.zuo.restaurant.service.UserService;

@Controller("adminController")
@RequestMapping("/admin")
public class adminController {
	@Resource
	private UserService userService;
	//登录
	@RequestMapping(value={"/login",""})
	public String login(HttpSession session,String username,String password,Model model) throws Exception{
		
		//调用service进行用户身份验证
		User user=userService.findUserLogin(username, password);
		//。。。
		//在session中保存用户身份信息
		if(user!=null){
			session.setAttribute("loginUser", user);
			if(user.getType()==0){
				model.addAttribute("loginUser", user);
				return "admin";
			}else {
				throw new CustomException("抱歉，您没有权限!");
			}
		}
		
		return "/login";
	}
	
	//退出
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		
		return "redirect:/admin";
	}
	
	
//	@RequestMapping(value="/main",method=RequestMethod.POST)
//	public String main() throws Exception{
//		return "admin";
//	}
	
	
	
	
	
	
	
	

	
	

}
