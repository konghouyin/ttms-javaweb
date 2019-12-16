package xupt.se.ttms.domain;

import java.sql.Date;

public class Plan {
    private Integer plan_id;
    private  Integer room_id;
    private Integer play_id;
    private Date plan_startime;
    private float plan_money;
    private String plan_language;
	public Integer getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(Integer plan_id) {
		this.plan_id = plan_id;
	}
	public Integer getRoom_id() {
		return room_id;
	}
	public void setRoom_id(Integer room_id) {
		this.room_id = room_id;
	}
	public Integer getPlay_id() {
		return play_id;
	}
	public void setPlay_id(Integer play_id) {
		this.play_id = play_id;
	}
	public Date getPlan_startime() {
		return plan_startime;
	}
	public void setPlan_startime(Date plan_startime) {
		this.plan_startime = plan_startime;
	}
	public float getPlan_money() {
		return plan_money;
	}
	public void setPlan_money(float plan_money) {
		this.plan_money = plan_money;
	}
	public String getPlan_language() {
		return plan_language;
	}
	public void setPlan_language(String plan_language) {
		this.plan_language = plan_language;
	}

}
