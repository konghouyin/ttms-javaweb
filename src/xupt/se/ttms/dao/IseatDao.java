package xupt.se.ttms.dao;

import java.util.List;

import xupt.se.ttms.domain.Seat;


public interface IseatDao {
	int seatInsert(Seat seat);
	
	 int seatDelete(int seat_id);

	 int seatUpdate(Seat seat);

	 List<Seat> getUserAll();
}
