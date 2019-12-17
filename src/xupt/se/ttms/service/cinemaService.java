package xupt.se.ttms.service;

import java.util.List;

import lombok.experimental.var;
import xupt.se.ttms.dao.IcinemaDao;
import xupt.se.ttms.dao.IseatDao;
import xupt.se.ttms.dao.IuserDao;
import xupt.se.ttms.dao.impl.cinemaDaoImpl;
import xupt.se.ttms.domain.Cinema;
import xupt.se.ttms.domain.Seat;
import xupt.se.ttms.domain.User;
import xupt.se.ttms.factory.daoFactory;

public class cinemaService {

	private IcinemaDao cinemaDao = daoFactory.createCinemaDao();
	private IseatDao seatDao = daoFactory.createSeatDao();

	public int cinemaAdd(String roomname, String roomrow, String roomcol, String roomstatus, String seatarr) {
		Cinema person = new Cinema();
		person.setRoom_name(roomname);
		person.setRoom_row(Integer.valueOf(roomrow));
		person.setRoom_col(Integer.valueOf(roomcol));
		person.setRoom_status(Integer.valueOf(roomstatus));
		int roomid = cinemaDao.cinemaInsert(person);
		String[] seatArr = seatarr.split(",");
		System.out.print(seatArr);
		int flag = 0;
		for (int row = 1; row <= Integer.valueOf(roomrow); row++) {
			for (int col = 1; col <= Integer.valueOf(roomcol); col++) {
				Seat seat = new Seat();
				seat.setRoom_id(roomid);
				seat.setSeat_row(row);
				seat.setSeat_col(col);
				seat.setSeat_status(Integer.valueOf(seatArr[flag]));
				flag++;
				seatDao.seatInsert(seat);
			}
		}
		return 1;
	}

	public List<Cinema> cinemaQuery() {
		cinemaDaoImpl cinema = new cinemaDaoImpl();
		return cinema.getCineameAll();
	}

	public int cinemaDelete(int room_id) {
		cinemaDao.cinemaDelete(room_id);
		return room_id;
	}

	public Cinema cinemaUpdate(String roomid, String roomname, String roomrow, String roomcol, String roomstatus,
			String seatarr) {
		Cinema person = new Cinema();
		person.setRoom_id(Integer.valueOf(roomid));
		person.setRoom_name(roomname);
		person.setRoom_row(Integer.valueOf(roomrow));
		person.setRoom_col(Integer.valueOf(roomcol));
		person.setRoom_status(Integer.valueOf(roomstatus));
		cinemaDao.cinemaUpdate(person);
		String[] seatArr = seatarr.split(",");
		System.out.print(seatArr);
		int flag = 0;
		seatDao.seatDelete(Integer.valueOf(roomid));
		for (int row = 1; row <= Integer.valueOf(roomrow); row++) {
			for (int col = 1; col <= Integer.valueOf(roomcol); col++) {
				Seat seat = new Seat();
				seat.setRoom_id(Integer.valueOf(roomid));
				seat.setSeat_row(row);
				seat.setSeat_col(col);
				seat.setSeat_status(Integer.valueOf(seatArr[flag]));
				flag++;
				seatDao.seatInsert(seat);
			}
		}				
		return null;
	}

	public Cinema cinemaQueryOne(String room_id) {
		cinemaDaoImpl cinema = new cinemaDaoImpl();
		return cinema.getCineameOne(Integer.valueOf(room_id));
	}
	
	public List<Seat> seatQueryAll(String room_id) {
		cinemaDaoImpl cinema = new cinemaDaoImpl();
		return cinema.getSeatAll(Integer.valueOf(room_id));
	}
}
