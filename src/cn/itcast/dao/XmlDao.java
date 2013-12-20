package cn.itcast.dao;

import cn.itcast.domain.UserBean;

public interface XmlDao {

	void add(UserBean user);

	UserBean find(String username, String password);

	boolean find(String username);

}