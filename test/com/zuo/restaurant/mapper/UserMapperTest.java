package com.zuo.restaurant.mapper;

import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zuo.restaurant.po.User;
import com.zuo.restaurant.po.UserCustom;
import com.zuo.restaurant.service.UserService;
import com.zuo.restaurant.vo.UserQueryVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext*.xml")
public class UserMapperTest {
	static Random rand=new Random();
	
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}
	@Resource(name="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private ApplicationContext applicationContext;

	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext*.xml");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testqueryUserGeneral() throws Exception {
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		User user = userMapper.findUserById(1);
		System.out.println(user.getName());

	}

	@Test
	public void testFindUserById() throws Exception {
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		User user = userMapper.findUserById(1);
		System.out.println(user.getName());

	}

	@Test
	public void testfindUserByUsername() throws Exception {
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setName("user1");
		userCustom.setPassword("1234");
		userQueryVo.setUserCustom(userCustom);
		User user=userMapper.queryUserGeneral(userQueryVo);
		System.out.println(user);
	}

	@Test
	public void testInsertUser() throws Exception {
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		User user = new User();
		user.setName("小左");
		user.setPassword("123");
		user.setType(0);
		userMapper.insertUser(user);
		System.out.println(user.getId());
	}

	@Test
	public void testDeleteUser() throws Exception {
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		userMapper.deleteUserById(2);
	}

	@Test
	public void testFindUserList() throws Exception {
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		// userCustom.setName("user");
		userCustom.setType(1);
		userQueryVo.setUserCustom(userCustom);
		List<UserCustom> userCustoms = userMapper.findUserList(userQueryVo);
		System.out.println(userCustoms);
	}

	@Test
	public void testFindUserCount() throws Exception {
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		// userCustom.setName("user");
		userCustom.setType(0);
		userQueryVo.setUserCustom(userCustom);
		int userCustoms = userMapper.findUserCount(userQueryVo);
		System.out.println(userCustoms);
	}
	
	@Test
	public void saveUser() throws Exception{
		UserService userService=(UserService) applicationContext.getBean("userService");
		for(int i=7;i<100;i++){
			User u=new User();
			u.setName("user"+i);
			u.setPassword("123");
			u.setNickname(ranName());
			u.setType(1);
			userService.add(u);
		}
	}
	@Test
	public void testfindUserList() throws Exception{
//		UserService userService=(UserService) applicationContext.getBean("userService");
		UserQueryVo userQueryVo=new UserQueryVo();
		UserCustom userCustom=new UserCustom();
		
		userQueryVo.setUserCustom(userCustom);
		userService.findUserList(userQueryVo);
	}
	
	
	
	static String[] firstNam = new String[] { "张", "刘", "李", "左", "付", "王", "汪", "赵", "于", "许", "徐", "林", "候", "乌", "左",
			"盖", "周", "曹", "宋", "张", "孙", "陈", "白", "苗" };
	static String[] lastName = new String[] { "泽奇", "玉晖", "海燕", "鑫", "清伟", "强", "中建", "丽娜", "晓宁", "子傲", "君妍", "静", "思竹",
			"嘉敏", "宇宁", "博", "依函", "一涵", "迪", "宇", "东海", "昭君", "鸿飞", "成林", "承烨", "日更", "铎文", "杰伦" };

	public static String ranName() {
		return firstNam[rand.nextInt(firstNam.length)] + lastName[rand.nextInt(lastName.length)];
	}

}
