package xupt.se.ttms.domain;


public class Play {
	private Integer play_id;
	private String play_name;
	private String play_director;
	private String play_performer;
	private String play_type;
	public Integer getPlay_id() {
		return play_id;
	}

	public void setPlay_id(Integer play_id) {
		this.play_id = play_id;
	}

	public String getPlay_name() {
		return play_name;
	}

	public void setPlay_name(String play_name) {
		this.play_name = play_name;
	}

	public String getPlay_director() {
		return play_director;
	}

	public void setPlay_director(String play_director) {
		this.play_director = play_director;
	}

	public String getPlay_performer() {
		return play_performer;
	}

	public void setPlay_performer(String play_performer) {
		this.play_performer = play_performer;
	}

	public String getPlay_type() {
		return play_type;
	}

	public void setPlay_type(String play_type) {
		this.play_type = play_type;
	}

	public String getPlay_length() {
		return play_length;
	}

	public void setPlay_length(String play_length) {
		this.play_length = play_length;
	}

	public String getPlay_country() {
		return play_country;
	}

	public void setPlay_country(String play_country) {
		this.play_country = play_country;
	}

	public String getPlay_language() {
		return play_language;
	}

	public void setPlay_language(String play_language) {
		this.play_language = play_language;
	}

	public String getPlay_status() {
		return play_status;
	}

	public void setPlay_status(String play_status) {
		this.play_status = play_status;
	}

	public String getPlay_pic() {
		return play_pic;
	}

	public void setPlay_pic(String play_pic) {
		this.play_pic = play_pic;
	}

	public String getPlay_message() {
		return play_message;
	}

	public void setPlay_message(String play_message) {
		this.play_message = play_message;
	}

	public String getPlay_link() {
		return play_link;
	}

	public void setPlay_link(String play_link) {
		this.play_link = play_link;
	}

	public String getPlay_path() {
		return play_path;
	}

	public void setPlay_path(String play_path) {
		this.play_path = play_path;
	}

	private String play_length;
	private String play_country;
	private String play_language;
	private String play_status;
	private String play_pic;
	private String play_message;
	private String play_link;
	private String play_path;
	
	@Override
	public String toString() {
		return "Play [play_id=" + play_id + ", play_name=" + play_name + ", play_director=" + play_director
				+ ", play_performer=" + play_performer + ", play_type=" + play_type + ", play_length=" + play_length
				+ ", play_country=" + play_country + ", play_language=" + play_language + ", play_status=" + play_status
				+ ", play_pic=" + play_pic + ", play_message=" + play_message + ", play_link=" + play_link
				+ ", play_path=" + play_path + "]";
	}	
}
