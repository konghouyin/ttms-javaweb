package xupt.se.ttms.domain;

/**
 * @program: ttms-javaweb
 * @author: WolfSky
 * @create: 2019-11-06 10:40
 **/
public class Reporttype {
    private Integer reportType_id;
    private String reportType_name;
    private Integer reportType_status;

    public Integer getReportType_id() {
        return reportType_id;
    }

    public void setReportType_id(Integer reportType_id) {
        this.reportType_id = reportType_id;
    }

    public String getReportType_name() {
        return reportType_name;
    }

    public void setReportType_name(String reportType_name) {
        this.reportType_name = reportType_name;
    }

    public Integer getReportType_status() {
        return reportType_status;
    }

    public void setReportType_status(Integer reportType_status) {
        this.reportType_status = reportType_status;
    }

    @Override
    public String toString() {
        return "Reporttype{" +
                "reportType_id=" + reportType_id +
                ", reportType_name='" + reportType_name + '\'' +
                ", reportType_status=" + reportType_status +
                '}';
    }
}
