package xupt.se.ttms.domain;




public class User {
	private Integer user_id;
	private String user_status;
	private String user_password;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_status() {
		return user_status;
	}
	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Integer getUser_age() {
		return user_age;
	}
	public void setUser_age(Integer user_age) {
		this.user_age = user_age;
	}
	public Integer getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(Integer user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	public String getUser_mail() {
		return user_mail;
	}
	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}
	public String getUser_time() {
		return user_time;
	}
	public void setUser_time(String user_time) {
		this.user_time = user_time;
	}
	private String user_name;
	private Integer user_age;
	private Integer user_sex;
	private String user_tel;
	private String user_mail;
	private String user_time;
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_status=" + user_status + ", user_password=" + user_password
				+ ", user_name=" + user_name + ", user_age=" + user_age + ", user_sex=" + user_sex + ", user_tel="
				+ user_tel + ", user_mail=" + user_mail + ", user_time=" + user_time + "]";
	}
	
	
	
}
