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
<<<<<<< HEAD
			User back1 = userDao.userGetByName(person);
			return back1;
=======
			System.out.println("娉ㄥ唽鏃舵病鏈夋壘鍒板悓鍚嶇敤鎴�");
			return person;
>>>>>>> e3e5d4fc6cb5332627cbaf2d311a3b40b1abab13
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
			// 鏁版嵁搴撴病宸茬粡鏈夎鐢ㄦ埛鍚�
		} else if (back.getUser_password().equals(password)) {
			return back;
		} else {
			return null;
			// 瀵嗙爜閿欒
		}
	}
}
