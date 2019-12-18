package xupt.se.ttms.dao;

import java.util.List;

import xupt.se.ttms.domain.Play;


public interface IplayDao {
	 int playInsert(Play play);
		
	 int playDelete(int play_id);

	 int playUpdate(Play play);

	 List<Play> getPlayAll();
	 
	 Play playGetByID(String playid);

}
