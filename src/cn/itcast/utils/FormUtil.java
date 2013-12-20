package cn.itcast.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.sun.org.apache.commons.beanutils.BeanUtils;

import cn.itcast.form.FormBean;

public class FormUtil {

	public static <T> T request2formbean(HttpServletRequest request,Class<T> formbean)
	{
		try {
			T fb= formbean.newInstance();
			Enumeration en = request.getParameterNames();
			while(en.hasMoreElements())
			{
				String name = (String) en.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(fb, name, value);
			}
			return fb;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	
}
