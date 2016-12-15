package com.zuo.restaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuo.restaurant.exception.CustomException;
import com.zuo.restaurant.mapper.OrdersItemsMapper;
import com.zuo.restaurant.mapper.OrdersMapper;
import com.zuo.restaurant.mapper.UserMapper;
import com.zuo.restaurant.po.Pager;
import com.zuo.restaurant.po.SystemContext;
import com.zuo.restaurant.po.User;
import com.zuo.restaurant.po.UserCustom;
import com.zuo.restaurant.service.UserService;
import com.zuo.restaurant.vo.UserQueryVo;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private OrdersItemsMapper ordersItemsMapper;

	@Override
	public void add(User user) throws Exception {
		if(this.findUserByUsername(user.getName())!=null){
			throw new CustomException("该用户名已经存在");
		}
		 userMapper.insertUser(user);
	}

	@Override
	public void update(User user) throws Exception {
		userMapper.updateUser(user);
	}

	@Override
	public void delete(Integer id) throws Exception {
		// 删除关联订单 删除订单与菜的关联
		try {
			List<Integer> orderId=ordersMapper.selectOrderIdByUserId(id);
			for(int oId : orderId){
				ordersItemsMapper.deleteOrdersItemsByOrderId(oId);
				ordersMapper.deleteOrder(oId);
			}
			userMapper.deleteUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception {
		return userMapper.findUserList(userQueryVo);
	}

	@Override
	public User findUserById(Integer id) throws Exception {
		return userMapper.findUserById(id);
	}

	@Override
	public User findUserByUsername(String username) throws Exception {
		return userMapper.findUserByUsername(username);
	}

	@Override
	public User findUserLogin(String username, String password) throws Exception {
		UserQueryVo userQueryVo=new UserQueryVo();
		UserCustom userCustom=new UserCustom();
		userCustom.setName(username);
		userCustom.setPassword(password);
		userQueryVo.setUserCustom(userCustom);
		return userMapper.findUserLogin(userQueryVo);
	}

	@Override
	public Pager<UserCustom> findAllUser(String nickname,Integer type) throws Exception {
		int pageSize=SystemContext.getPageSize();
		int pageOffset=SystemContext.getPageOffset();
		int currentPage;
		if(pageSize<=0){
			pageSize=10;
		}
		if(pageOffset<=0){
			pageOffset=0;
		}
		currentPage=pageOffset/10*pageSize;
		
		UserCustom userCustom=new UserCustom();
		UserQueryVo userQueryVo=new UserQueryVo();
		userCustom.setNickname(nickname);
		userCustom.setType(type);
		userCustom.setCurrentPage(currentPage);
		userCustom.setPageSize(pageSize);
		userQueryVo.setUserCustom(userCustom);
		List<UserCustom> userCustoms =userMapper.findUserList(userQueryVo);
		
		Pager<UserCustom> pager=new Pager<>();
		pager.setPageOffset(pageOffset);
		pager.setPageSize(pageSize);
		pager.setDatas(userCustoms);
		long count=userMapper.findUserCount(userQueryVo);
		pager.setTotalRecord(count);
		
		return pager;
	}

	@Override
	public boolean checkUserType(User user) throws Exception {
		if(user.getType()==1){
			return false;
		}
		return true;
	}

}
