package xupt.se.ttms.service;

import xupt.se.ttms.dao.*;
import xupt.se.ttms.domain.User;
import xupt.se.ttms.factory.*;

import java.util.List;

public class userService {
	private IuserDao userDao = daoFactory.createUserDao();

	public User register(String userName, String password) {
		User person = new User();
		person.setUser_name(userName);
		person.setUser_password(password);
		User back = userDao.userGetByName(person);
		if (back == null) {
			userDao.userInsert(person);
			System.out.println("注册时没有找到同名用户");
			return person;
		}else {
			return null;
		}
	}

	public User login(String userName, String password) {
		User person = new User();
		person.setUser_name(userName);
		person.setUser_password(password);

		User back = userDao.userGetByName(person);
		if (back == null) {
			return null;
			// 数据库没已经有该用户名
		} else if (back.getUser_password().equals(password)) {
			return back;
		} else {
			return null;
			// 密码错误
		}
	}
	public List<User> personquery(){
		List<User> content=userDao.getUserAll();
		if(content==null){
			return null;
		}else{
			return content;
		}
	}
	public User personadd(String userName,String password,String pelmail,String status){
		User person=new User();
		person.setUser_name(userName);
		person.setUser_password(password);
		person.setUser_mail(pelmail);
		person.setUser_status(status);
		int adc=userDao.userInsert1(person);
		return person;
	}
}
