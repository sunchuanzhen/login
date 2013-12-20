package cn.itcast.web.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.form.FormBean;
import cn.itcast.utils.FormUtil;

import com.sun.org.apache.commons.beanutils.BeanUtils;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//1、获取表单数据，并且封装到formbean当中
		FormBean formbean = FormUtil.request2formbean(request,FormBean.class);
		
		//2、对表单数据进行合法性校验，如果检验失败，返回失败信息，如果校验成功继续往下走
		boolean isOk = formbean.validate();
		HashMap error = new HashMap();
		if(!isOk)
		{
			error = formbean.getError();
//			System.out.println(request.getContextPath());
			request.setAttribute("error", error);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
		}
		//3、调用Web service对数据进行处理，如果用户已经存在，返回用户已经存在的信息，并且跳转到注册页面
		
		//4、如果失败是其他问题的话，就跳转到全局的消息页面，为用户提供友好的信息提示
		
		//5、如果注册成功，提示用户注册成功，并且跳转到登录页面
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
