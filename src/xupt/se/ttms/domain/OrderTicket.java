package xupt.se.ttms.domain;

import java.sql.Date;

public class OrderTicket {
    private Integer orderticket_id;
    private  Integer user_id;
    private float orderticket_money;
    private String ordertick_history;
    private Date ordertick_time;
    private Integer ordertick_status;
	public Integer getOrderticket_id() {
		return orderticket_id;
	}
	public void setOrderticket_id(Integer orderticket_id) {
		this.orderticket_id = orderticket_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public float getOrderticket_money() {
		return orderticket_money;
	}
	public void setOrderticket_money(float orderticket_money) {
		this.orderticket_money = orderticket_money;
	}
	public String getOrdertick_history() {
		return ordertick_history;
	}
	public void setOrdertick_history(String ordertick_history) {
		this.ordertick_history = ordertick_history;
	}
	public Date getOrdertick_time() {
		return ordertick_time;
	}
	public void setOrdertick_time(Date ordertick_time) {
		this.ordertick_time = ordertick_time;
	}
	public Integer getOrdertick_status() {
		return ordertick_status;
	}
	public void setOrdertick_status(Integer ordertick_status) {
		this.ordertick_status = ordertick_status;
	}
}
