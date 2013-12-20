package cn.itcast.service.impl;


import cn.itcast.dao.impl.XmlDaoImpl;
import cn.itcast.domain.UserBean;
import cn.itcast.exception.UserExitsException;
import cn.itcast.utils.DigestUtil;

/**
 * ��Ҫ����web���ṩ��Ӧ�ķ����߼�
 * @author Administrator
 *
 */
public class LoginService {
	
	//Ϊweb���ṩ��¼�߼�
	public int login(UserBean user)
	{
		XmlDaoImpl dao = new XmlDaoImpl();
		if(user!=null && dao.find(user.getUsername(), DigestUtil.getMd5(user.getPassword()))!=null)
		{
			return 1;
		}else if(user!=null && dao.find(user.getUsername()))
		{
			return -1;//�������
		}else{
		
			return -2;//�û���������
		}		
	}
	
	//Ϊweb���ṩע���߼�
	public void register(UserBean user) throws UserExitsException
	{
		//��ʼ�����ݲ�
		XmlDaoImpl dao = new XmlDaoImpl();
		//���ж��û��Ƿ���ڣ���������ھ������ݿ��������
		if(user!=null&&!dao.find(user.getUsername()))
		{
			String password = user.getPassword();
			user.setPassword(DigestUtil.getMd5(password));
			dao.add(user);
			//����û��Ѿ����ھͱ��û��Ѵ����쳣
		}else{
			throw new UserExitsException();//���ʱ���׳�����ʱ�쳣�����ϲ㴦��֮����û�һ���к���ʾ��
		}	
		
	}
	
	
}
