package xupt.se.ttms.domain;

/**
 * @program: ttms-javaweb
 * @author: WolfSky
 * @create: 2019-11-06 10:28
 **/
public class Comment {
    private Integer comment_id;
    private  Integer play_id;
    private Integer user_id;
    private String comment_message;
    private String comment_time;
    private Integer comment_grade;
    private Integer comment_status;
    private Integer comment_dateout;

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public Integer getPlay_id() {
        return play_id;
    }

    public void setPlay_id(Integer play_id) {
        this.play_id = play_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getComment_message() {
        return comment_message;
    }

    public void setComment_message(String comment_message) {
        this.comment_message = comment_message;
    }

    public String getComment_time() {
        return comment_time;
    }

    public void setComment_time(String comment_time) {
        this.comment_time = comment_time;
    }

    public Integer getComment_grade() {
        return comment_grade;
    }

    public void setComment_grade(Integer comment_grade) {
        this.comment_grade = comment_grade;
    }

    public Integer getComment_status() {
        return comment_status;
    }

    public void setComment_status(Integer comment_status) {
        this.comment_status = comment_status;
    }

    public Integer getComment_dateout() {
        return comment_dateout;
    }

    public void setComment_dateout(Integer comment_dateout) {
        this.comment_dateout = comment_dateout;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", play_id=" + play_id +
                ", user_id=" + user_id +
                ", comment_message='" + comment_message + '\'' +
                ", comment_time='" + comment_time + '\'' +
                ", comment_grade=" + comment_grade +
                ", comment_status=" + comment_status +
                ", comment_dateout=" + comment_dateout +
                '}';
    }
}
