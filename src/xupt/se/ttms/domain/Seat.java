package xupt.se.ttms.domain;

public class Seat {
    private Integer seat_id;
    private Integer room_id;
    private Integer seat_row;
    private Integer seat_col;
    private Integer seat_status;
	public Integer getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(Integer seat_id) {
		this.seat_id = seat_id;
	}
	public Integer getRoom_id() {
		return room_id;
	}
	public void setRoom_id(Integer roomid) {
		this.room_id = roomid;
	}
	public Integer getSeat_row() {
		return seat_row;
	}
	public void setSeat_row(Integer seat_row) {
		this.seat_row = seat_row;
	}
	public Integer getSeat_col() {
		return seat_col;
	}
	public void setSeat_col(Integer seat_col) {
		this.seat_col = seat_col;
	}
	public Integer getSeat_status() {
		return seat_status;
	}
	public void setSeat_status(Integer seat_status) {
		this.seat_status = seat_status;
	}
}
