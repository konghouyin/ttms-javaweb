package xupt.se.ttms.dao;

import xupt.se.ttms.domain.Report;

import java.util.List;

/**
 * @program: ttms-javaweb
 * @author: WolfSky
 * @create: 2019-11-06 12:48
 **/
public interface IreportDao {

    //增删改查
    int reportInsert(Report report);

    int reportDelete(int report_id);

    int reportUpdate(Report report);

    List<Report> getReportAll();
}
