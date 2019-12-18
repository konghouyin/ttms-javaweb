package xupt.se.ttms.dao;
import	java.util.List;
import xupt.se.ttms.domain.Reporttype;



/**
 * @program: ttms-javaweb
 * @author: WolfSky
 * @create: 2019-11-06 10:43
 **/
public interface IreporttypeDao {
    //增删查
    int reporttypeInsert(Reporttype reporttype);
    
    int reporttypeDelete(String reportType_id);


    List<Reporttype> getReportTypeAll();

    List<String> getReportByStatus();

    int getReportType(String type);



}
