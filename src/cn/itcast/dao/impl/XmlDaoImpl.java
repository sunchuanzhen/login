package cn.itcast.dao.impl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import cn.itcast.dao.XmlDao;
import cn.itcast.domain.UserBean;
import cn.itcast.utils.XmlUtil;

public class XmlDaoImpl implements XmlDao {
	
	//向xml中添加用户
	public void add(UserBean user)
	{
		try {
			Document document = XmlUtil.getDoc();
			Element element = document.getRootElement().addElement("user");
			element.setAttributeValue("id", user.getId());
			element.setAttributeValue("username", user.getUsername());
			element.setAttributeValue("password", user.getPassword());
			element.setAttributeValue("email", user.getEmail());
			element.setAttributeValue("birthday", user.getBirthday().toLocaleString());
			try {
				XmlUtil.write2xml(document);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (DocumentException e) {
			throw new RuntimeException();
		}
		
	}
	
	//查找用户名和密码同时匹配的用户，登录的时候用
	public UserBean find(String username,String password)
	{
		try {
			Document document = XmlUtil.getDoc();
			Element  element = (Element) document.selectSingleNode("//users/user[@username='"+username+"' and @password='"+password+"']");
			if(element != null)
			{
				UserBean user = new UserBean();
				user.setId(element.attributeValue("id"));
				user.setUsername(element.attributeValue("username"));
				user.setPassword(element.attributeValue("password"));
				user.setEmail(element.attributeValue("email"));
				String date  = element.attributeValue("birthday");
//				System.out.println(date);
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date birthday = format.parse(date);
					user.setBirthday(birthday);	
				} catch (ParseException e) {
					e.printStackTrace();
					throw new RuntimeException();
				}
				return user;
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//查找用户是否存在，注册时候用
	public boolean find(String username)
	{
		try {
			Document document = XmlUtil.getDoc();
			Element element = (Element) document.selectSingleNode("//users/user[@username='"+username+"']");
			if(element != null)
				return true;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
