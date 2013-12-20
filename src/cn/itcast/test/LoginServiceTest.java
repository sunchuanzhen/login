package cn.itcast.test;

import java.util.Date;

import org.junit.Test;

import cn.itcast.domain.UserBean;
import cn.itcast.exception.UserExitsException;
import cn.itcast.service.impl.LoginService;

public class LoginServiceTest {

	@Test
	public void RegisterTest()
	{
		LoginService service = new LoginService();
		UserBean user = new UserBean();
		user.setId("15241");
		user.setUsername("阿江");
		user.setPassword("123456");
		user.setEmail("a@a.com");
		long d = System.currentTimeMillis();
		user.setBirthday(new Date(d));
		
		try {
			service.register(user);
		} catch (UserExitsException e) {
			System.out.println("您将要注册的用户名已经存在请更换其他名称");
		}
	}
	
	@Test
	public void LoginTest()
	{
		LoginService service = new LoginService();
		UserBean user = new UserBean();
		user.setId("15241");
		user.setUsername("阿江dd");
		user.setPassword("123456");
		user.setEmail("a@a.com");
		long d = System.currentTimeMillis();
		user.setBirthday(new Date(d));
		
		int state = service.login(user);
		System.out.println(state);
	}
	
}
