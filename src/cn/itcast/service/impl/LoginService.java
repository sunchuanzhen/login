package cn.itcast.service.impl;


import cn.itcast.dao.impl.XmlDaoImpl;
import cn.itcast.domain.UserBean;
import cn.itcast.exception.UserExitsException;
import cn.itcast.utils.DigestUtil;

/**
 * 主要是向web层提供相应的服务逻辑
 * @author Administrator
 *
 */
public class LoginService {
	
	//为web层提供登录逻辑
	public int login(UserBean user)
	{
		XmlDaoImpl dao = new XmlDaoImpl();
		if(user!=null && dao.find(user.getUsername(), DigestUtil.getMd5(user.getPassword()))!=null)
		{
			return 1;
		}else if(user!=null && dao.find(user.getUsername()))
		{
			return -1;//密码错误
		}else{
		
			return -2;//用户名不存在
		}		
	}
	
	//为web层提供注册逻辑
	public void register(UserBean user) throws UserExitsException
	{
		//初始化数据层
		XmlDaoImpl dao = new XmlDaoImpl();
		//先判断用户是否存在，如果不存在就往数据库里面添加
		if(user!=null&&!dao.find(user.getUsername()))
		{
			String password = user.getPassword();
			user.setPassword(DigestUtil.getMd5(password));
			dao.add(user);
			//如果用户已经存在就报用户已存在异常
		}else{
			throw new UserExitsException();//这个时候抛出编译时异常，供上层处理之后给用户一个有好提示。
		}	
		
	}
	
	
}
