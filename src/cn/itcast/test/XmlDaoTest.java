package cn.itcast.test;

import java.util.Date;

import javax.persistence.Temporal;

import org.junit.Test;

import cn.itcast.dao.XmlDao;
import cn.itcast.dao.impl.XmlDaoImpl;
import cn.itcast.domain.UserBean;

public class XmlDaoTest {

	@Test
	public void addTest()
	{
		UserBean user = new UserBean();
		user.setId("15241");
		user.setUsername("alice");
		user.setPassword("123456");
		user.setEmail("a@a.com");
		long d = System.currentTimeMillis();
		user.setBirthday(new Date(d));
		
		XmlDao xmldao = new XmlDaoImpl();
		xmldao.add(user);
	}
	
	@Test
	public void findTest()
	{
		XmlDao xmldao = new XmlDaoImpl();
		UserBean user = xmldao.find("alice", "123456");
		System.out.println(user.getBirthday().toLocaleString());
		
	}
	
	@Test
	public void findTest2()
	{
		XmlDao xmldao = new XmlDaoImpl();
		System.out.println(xmldao.find("alice"));
	}
	
}
