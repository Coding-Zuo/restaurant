package com.zuo.restaurant.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zuo.restaurant.po.Pager;
import com.zuo.restaurant.po.SystemContext;
import com.zuo.restaurant.po.User;
import com.zuo.restaurant.po.UserCustom;
import com.zuo.restaurant.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext*.xml")
public class UserServiceImplTest {
	@Resource
	private UserService userService;
	

	@Test
	public void testPageUser() throws Exception {
//		UserCustom userCustom=new UserCustom();
		SystemContext.setPageSize(10);
		SystemContext.setPageOffset(2);
//		int pageSize=SystemContext.getPageSize();
//		int pageOffset=SystemContext.getPageOffset();
//		int currentPage=pageOffset*pageSize+1;
		
//		System.out.println(currentPage);
//		userCustom.setPageSize(pageSize);
//		userQueryVo.setUserCustom(userCustom);
		
		Pager<UserCustom>pager=userService.findAllUser(null,null);
		for(UserCustom u:pager.getDatas()){
			System.out.println(u);
		}
		
	}
	@Test
	public void testcheckUserType() throws Exception {
		User user=userService.findUserById(1);
		System.out.println(userService.checkUserType(user));
	}
	@Test
	public void testFindByUsername() throws Exception {
		User user=userService.findUserByUsername("user1");
		System.out.println(user.getNickname());
	}
	@Test
	public void testUserLogin() throws Exception {
		User user=userService.findUserLogin("user1", "123");
		System.out.println(user);
	}
	@Test
	public void testDelete() throws Exception {
		userService.delete(100);
	}
	@Test
	public void testlogin() throws Exception {
		User user=userService.findUserLogin("user2", "123");
		System.out.println(user);
	}
	
	
	
	
	
	
	

}
