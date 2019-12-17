package xupt.se.ttms.domain;

/**
 * @program: ttms-javaweb
 * @author: WolfSky
 * @create: 2019-11-06 10:37
 **/
public class Report {
    private Integer report_id;
    private Integer comment_id;
    private Integer user_id;
    private Integer report_typeId;
    private String report_main;
    private Integer reprot_status;

    public Integer getReport_id() {
        return report_id;
    }

    public void setReport_id(Integer report_id) {
        this.report_id = report_id;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getReport_typeId() {
        return report_typeId;
    }

    public void setReport_typeId(Integer report_typeId) {
        this.report_typeId = report_typeId;
    }

    public String getReport_main() {
        return report_main;
    }

    public void setReport_main(String report_main) {
        this.report_main = report_main;
    }

    public Integer getReprot_status() {
        return reprot_status;
    }

    public void setReprot_status(Integer reprot_status) {
        this.reprot_status = reprot_status;
    }

    @Override
    public String toString() {
        return "Report{" +
                "report_id=" + report_id +
                ", comment_id=" + comment_id +
                ", user_id=" + user_id +
                ", report_typeId=" + report_typeId +
                ", report_main='" + report_main + '\'' +
                ", reprot_status=" + reprot_status +
                '}';
    }
}
