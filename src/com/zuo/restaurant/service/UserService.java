package com.zuo.restaurant.service;

import java.util.List;

import com.zuo.restaurant.po.Pager;
import com.zuo.restaurant.po.User;
import com.zuo.restaurant.po.UserCustom;
import com.zuo.restaurant.vo.UserQueryVo;

public interface UserService {
	
	public void add(User user) throws Exception;
	
	public void update(User user) throws Exception;
	
	public void delete(Integer id) throws Exception;
	
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	
	public User findUserById(Integer id) throws Exception;
	
	public User findUserByUsername(String username) throws Exception;
	
	public User findUserLogin(String username,String password) throws Exception;
	
	public Pager<UserCustom> findAllUser(String username,Integer type) throws Exception;
	//1是用户0是厨师，厨师返回true，用户返回false
	public boolean checkUserType(User user) throws Exception;
	
	
	
}





