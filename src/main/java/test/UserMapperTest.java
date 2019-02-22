package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import mapper.UserMapper;
import mapper.UserQueryMapper;
import model.User;
import model.UserExample;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMapperTest {
	private ApplicationContext applicationContext;
	private UserMapper userMapper;
	private SimpleDateFormat sdf;
	@Before
	public void setup() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		userMapper = (UserMapper) applicationContext.getBean("userMapper");
		sdf = new SimpleDateFormat("yyyy-MM-dd");
	}

	@Test
	public void testFindUserById() throws Exception {
		UserQueryMapper userQueryMapper = (UserQueryMapper) applicationContext.getBean("userQueryMapper");
		User user = userQueryMapper.findUserById(1);
		System.out.println(user.getId() + ":" + user.getUsername());
	}
//	@Test
	public void testInsertUser() throws ParseException {
		User user1 = new User();
		user1.setUsername("李磊磊");
		user1.setPassword("123qwe");
		user1.setGender("男");
		user1.setBirthday(sdf.parse("1992-01-01"));
		user1.setProvince("云南");
		user1.setCity("大理");
		user1.setEmail("lileilei@126.com");
		userMapper.insert(user1);
		System.out.println("1.插入了名为: " + user1.getUsername() + "的用户");
	}
//	@Test
	public void testSelectExample() throws ParseException {
		UserExample userExample = new UserExample();
		UserExample.Criteria  creteria = userExample.createCriteria();
		creteria.andUsernameEqualTo("李磊磊");
		creteria.andGenderNotEqualTo("女");
		creteria.andBirthdayBetween(sdf.parse("1991-01-01"), sdf.parse("1994-01-01"));
		creteria.andEmailIsNotNull();
		List<User> list = userMapper.selectByExample(userExample);
		for(User user : list) {
			System.out.println(user.getId() + ":" + user.getUsername());
		}
		User user = userMapper.selectByPrimaryKey(1);
		System.out.println("3.主键查询出id为1的用户，名为" + user.getUsername());
	}

//	@Test
	public void testUpdateUser() {
		User user3 = userMapper.selectByPrimaryKey(1);
		user3.setEmail("zhangsan@126.com");
		userMapper.updateByPrimaryKey(user3);
		System.out.println("4.更新id为" + user3.getId() + "的用户的所有信息");

		User user4 = new User();
		user4.setId(1);
		user4.setEmail("zhangsan@126.com");
		userMapper.updateByPrimaryKeySelective(user4);
		System.out.println("5.更新id为" + user4.getId() + "的用户Email为：" + user4.getEmail());
	}
//	@Test
	public void testDeleteUserById() {
		userMapper.deleteByPrimaryKey(6);
		User user5 = userMapper.selectByPrimaryKey(6);
		if(user5 == null) {
			System.out.println("6.删除id为6的用户成功，删除成功");
		}
	}



}
