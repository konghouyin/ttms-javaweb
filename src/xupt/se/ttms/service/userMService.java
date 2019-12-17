package xupt.se.ttms.service;

import xupt.se.ttms.dao.*;
import xupt.se.ttms.domain.User;
import xupt.se.ttms.factory.*;

public class userMService {
	private IuserDao userDao = daoFactory.createUserDao();

	public User register(String userName, int resource, String tel, String email, int age ) {
		User person = new User();
		person.setUser_name(userName);
		person.setUser_sex(resource);
		person.setUser_tel(tel);
		person.setUser_mail(email);
		person.setUser_age(age);
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
}
