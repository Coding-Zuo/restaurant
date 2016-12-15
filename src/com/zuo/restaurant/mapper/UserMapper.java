package com.zuo.restaurant.mapper;

import java.util.List;

import com.zuo.restaurant.po.User;
import com.zuo.restaurant.po.UserCustom;
import com.zuo.restaurant.vo.UserQueryVo;

public interface UserMapper {

	/**
	 * 根据id找用户
	 */
	public User findUserById(Integer id) throws Exception;
	/**
	 * 添加用户
	 */
	public void insertUser(User user) throws Exception;
	/**
	 * 根据id删用户
	 */
	public void deleteUserById(Integer id) throws Exception;
	/**
	 * 可以根据用户名和类型查筛选用户，为了分页
	 * @param userQueryVo
	 */
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	/**
	 * 用户数量，配合分页
	 * @param userQueryVo
	 */
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;
	
	public void updateUser(User user) throws Exception;
	
	public User findUserByUsername(String name) throws Exception;
	
	public UserCustom queryUserGeneral(UserQueryVo userQueryVo) throws Exception;
	
	public UserCustom findUserLogin(UserQueryVo userQueryVo) throws Exception;
	
	
	
	
	
	
	
	
	
}
