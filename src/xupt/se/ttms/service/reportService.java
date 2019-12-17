package xupt.se.ttms.service;

import xupt.se.ttms.dao.IreportDao;
import xupt.se.ttms.dao.IreporttypeDao;
import xupt.se.ttms.domain.Report;
import xupt.se.ttms.domain.ReportComment;
import xupt.se.ttms.domain.Reporttype;
import xupt.se.ttms.factory.*;

import java.util.List;

/**
 * @program: ttms-javaweb
 * @author: WolfSky
 * @create: 2019-12-16 23:24
 **/
public class reportService {
    private IreporttypeDao reporttypeDao =daoFactory.createReportTypeDao();
    private IreportDao reportDao = daoFactory.createReportDao();

    public int repTypeAdd(Reporttype type){
        reporttypeDao.reporttypeInsert(type);
        return 1;
    }

    public List<String> getReportTypeBySta(){
        return reporttypeDao.getReportByStatus();
    }

    public int delreportType(String typeName){
        try{
            reporttypeDao.reporttypeDelete(typeName);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public int repTypeAdd(String type){
        Reporttype type1 = new Reporttype();
        type1.setReportType_name(type);
        type1.setReportType_status(1);
        reporttypeDao.reporttypeInsert(type1);
        return 1;
    }

    public int getReportTypeId(String type){
        return reporttypeDao.getReportType(type);
    }

    public int addReport(int comment_id, Integer userid, int reportTypeId, String msg, int i) {
        Report report = new Report();
        report.setComment_id(comment_id);
        report.setUser_id(userid);
        report.setReport_typeId(reportTypeId);
        report.setReport_main(msg);
        report.setReprot_status(i);

        reportDao.reportInsert(report);
        return 1;
    }

    public List<ReportComment> reports() {
        List<ReportComment> commentReport = reportDao.getCommentReport();
        return commentReport;
    }
}
