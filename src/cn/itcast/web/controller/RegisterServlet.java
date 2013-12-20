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
		
		//1����ȡ�����ݣ����ҷ�װ��formbean����
		FormBean formbean = FormUtil.request2formbean(request,FormBean.class);
		
		//2���Ա����ݽ��кϷ���У�飬�������ʧ�ܣ�����ʧ����Ϣ�����У��ɹ�����������
		boolean isOk = formbean.validate();
		HashMap error = new HashMap();
		if(!isOk)
		{
			error = formbean.getError();
//			System.out.println(request.getContextPath());
			request.setAttribute("error", error);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
		}
		//3������Web service�����ݽ��д�������û��Ѿ����ڣ������û��Ѿ����ڵ���Ϣ��������ת��ע��ҳ��
		
		//4�����ʧ������������Ļ�������ת��ȫ�ֵ���Ϣҳ�棬Ϊ�û��ṩ�Ѻõ���Ϣ��ʾ
		
		//5�����ע��ɹ�����ʾ�û�ע��ɹ���������ת����¼ҳ��
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
