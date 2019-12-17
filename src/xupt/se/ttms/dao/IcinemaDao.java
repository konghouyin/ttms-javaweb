package xupt.se.ttms.dao;

import java.util.List;

import xupt.se.ttms.domain.Cinema;
import xupt.se.ttms.domain.Userlike;

public interface IcinemaDao {
	int cinemaInsert(Cinema cinema);
	
	 int cinemaDelete(int cinema_id);

	 int cinemaUpdate(Cinema cinema);

	 List<Cinema> getCineameAll();
	 
	 Cinema getCineameOne(int room_id);
}
