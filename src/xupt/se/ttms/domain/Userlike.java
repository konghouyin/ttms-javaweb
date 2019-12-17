package xupt.se.ttms.domain;


public class Userlike {
	public Integer getLike_id() {
		return like_id;
	}

	public void setLike_id(Integer like_id) {
		this.like_id = like_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getPlay_id() {
		return play_id;
	}

	public void setPlay_id(Integer play_id) {
		this.play_id = play_id;
	}

	private Integer like_id;
	private Integer user_id;
	private Integer play_id;
	
	@Override
	public String toString() {
		return "Userlike [like_id=" + like_id + ", user_id=" + user_id + ", play_id=" + play_id + "]";
	}
		
}
