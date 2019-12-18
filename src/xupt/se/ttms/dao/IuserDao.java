package xupt.se.ttms.dao;

import java.util.List;

import xupt.se.ttms.domain.User;

public interface IuserDao {

	 int userInsert(User user);
	
	 int userDelete(int user_id);

	 int userUpdate(User user);
	 
	 User userGetByName(User user);
	 
	 User userGetById(String user_id);
	 List<User> getUserAll();
}
