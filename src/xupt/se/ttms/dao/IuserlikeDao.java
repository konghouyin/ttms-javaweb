package xupt.se.ttms.dao;

import java.util.List;


import xupt.se.ttms.domain.Userlike;

public interface IuserlikeDao {
	int userlikeInsert(Userlike user);
	
	 int userlikeDelete(int user_id);

	 int userlikeUpdate(Userlike user);

	 List<Userlike> getUserAll();
}
