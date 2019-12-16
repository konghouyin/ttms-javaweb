package xupt.se.ttms.service;

import xupt.se.ttms.dao.*;
import xupt.se.ttms.domain.User;
import xupt.se.ttms.factory.*;

public class userService {
	private IuserDao userDao = daoFactory.createUserDao();

	public User register(String userName, String password) {
		User person = new User();
		person.setUser_name(userName);
		person.setUser_password(password);
		User back = userDao.userGetByName(person);
		if (back == null) {
			userDao.userInsert(person);
			User back1 = userDao.userGetByName(person);
			return back1;
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
}
