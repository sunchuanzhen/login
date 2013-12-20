package cn.itcast.form;

import java.util.HashMap;

import com.sun.org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class FormBean {

	private String id;
	private String username;
	private String nickname;
	private String password;
	private String password2;
	private String email;
	private String birthday;
	private HashMap error = new HashMap();
	public HashMap getError() {
		return error;
	}
	public void setError(HashMap error) {
		this.error = error;
	}
	public String getId() {
		return id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	public boolean validate()
	{
		boolean isOk = true;
		//�û�������Ϊ�գ���3-8λ��ĸ
		if(username==null||username.trim().equals(""))
		{
			isOk = false;
			error.put("username", "�û�������Ϊ�ջ����û�����ʽ����");
		}else if(!username.matches("[a-zA-z]{5,10}")){
			isOk = false;
			error.put("username", "�û�����ʽ����");
		}
		if(email==null||email.trim().equals(""))
		{
			isOk = false;
			error.put("email", "���䲻��Ϊ��");
		}else if(!email.matches("\\w+@\\w+\\.\\w+")){			
			isOk = false;
			error.put("email", "�����ʽ����");
		}
		if(password==null || password.trim().equals(""))
		{
			isOk = false;
			error.put("password", "���벻��Ϊ��");		
		}else if(!password.matches("\\d{3,8}")){
			isOk = false;
			error.put("password", "���������3-8λ����Ч����");
		}
		if(password2==null || password2.trim().equals(""))
		{
			isOk = false;
			error.put("password2", "ȷ�����벻��Ϊ��");
		}else if(password!=password2)
		{
			isOk=false;
			error.put("password2","�����������벻һ�£�����������");
		}
		if(birthday==null || birthday.trim().equals(""))
		{
			isOk=false;
			error.put("birthday", "���ڲ���Ϊ��");
		}else{
			try{
				DateLocaleConverter dlc = new DateLocaleConverter();
				dlc.convert(birthday, "yyyy-MM-dd");
			}catch(Exception e){
				isOk = false;
				error.put("birthday", "���ڸ�ʽ�������");
			}
		}
		if(nickname==null || nickname.trim().equals(""))
		{
			isOk = false;
			error.put("nickname", "�ǳƲ���Ϊ��");
		}else{
			if(!nickname.matches("^[\u4e00-\u9fa5]+")){
				isOk=false;
				error.put("nickname", "�ǳƱ���Ϊ����");
			}
		}
		return isOk;
	}
	
}
