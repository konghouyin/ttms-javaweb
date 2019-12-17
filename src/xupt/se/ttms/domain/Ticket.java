package xupt.se.ttms.domain;

import java.sql.Date;

public class Ticket {
    private Integer ticket_id;
    private  Integer orderticket_id;
    private Integer plan_id;
    private Integer seat_id;
    private Integer ticket_status;
    private Date ticket_time;
	public Integer getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(Integer ticket_id) {
		this.ticket_id = ticket_id;
	}
	public Integer getOrderticket_id() {
		return orderticket_id;
	}
	public void setOrderticket_id(Integer orderticket_id) {
		this.orderticket_id = orderticket_id;
	}
	public Integer getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(Integer plan_id) {
		this.plan_id = plan_id;
	}
	public Integer getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(Integer seat_id) {
		this.seat_id = seat_id;
	}
	public Integer getTicket_status() {
		return ticket_status;
	}
	public void setTicket_status(Integer ticket_status) {
		this.ticket_status = ticket_status;
	}
	public Date getTicket_time() {
		return ticket_time;
	}
	public void setTicket_time(Date ticket_time) {
		this.ticket_time = ticket_time;
	}
}
