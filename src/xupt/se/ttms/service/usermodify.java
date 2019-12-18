package xupt.se.ttms.service;

import  xupt.se.ttms.dao.*;
import xupt.se.ttms.domain.User;
import xupt.se.ttms.factory.*;

public class usermodify {
	private IuserDao userDao = daoFactory.createUserDao();

	public User register(String userName, String pass, String tel, String status) {
		User person = new User();
		person.setUser_name(userName);
		person.setUser_password(pass);
		person.setUser_tel(tel);
		person.setUser_status(status);
		User back = userDao.userGetByName(person);
		if (back == null) {
			userDao.userInsert(person);
			User back1 = userDao.userGetByName(person);
			return back1;
		}else {
			return null;
		}
	}
	public void userUpdate(User person) {
		int p=userDao.userUpdate(person);
	}
	public User userGetById(String user_id) {
		User p=userDao.userGetById(user_id);
		return p;
	}
}
