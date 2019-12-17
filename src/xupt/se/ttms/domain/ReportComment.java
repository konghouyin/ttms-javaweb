package xupt.se.ttms.domain;

/**
 * @program: ttms-javaweb
 * @author: WolfSky
 * @create: 2019-12-17 21:10
 **/
public class ReportComment {
    String username;
    String comment_message;
    String playname;
    String comment_time;
    String type;//举报类型

    @Override
    public String toString() {
        return "ReportComment{" +
                "username='" + username + '\'' +
                ", comment_message='" + comment_message + '\'' +
                ", playname='" + playname + '\'' +
                ", comment_time='" + comment_time + '\'' +
                ", type='" + type + '\'' +
                '}';
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
