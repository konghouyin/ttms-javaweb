package xupt.se.ttms.domain;

/**
 * @program: ttms-javaweb
 * @author: WolfSky
 * @create: 2019-12-17 21:10
 **/
public class ReportComment {
    Integer comment_id;
    String username;
    String comment_message;
    String playname;
    String comment_time;
    String type;//举报类型

    @Override
    public String toString() {
        return "ReportComment{" +
                "comment_id=" + comment_id +
                ", username='" + username + '\'' +
                ", comment_message='" + comment_message + '\'' +
                ", playname='" + playname + '\'' +
                ", comment_time='" + comment_time + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_time() {
        return comment_time;
    }

    public void setComment_time(String comment_time) {
        this.comment_time = comment_time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment_message() {
        return comment_message;
    }

    public void setComment_message(String comment_message) {
        this.comment_message = comment_message;
    }

    public String getPlayname() {
        return playname;
    }

    public void setPlayname(String playname) {
        this.playname = playname;
    }

}
