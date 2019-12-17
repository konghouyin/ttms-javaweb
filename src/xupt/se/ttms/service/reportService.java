package xupt.se.ttms.service;

import xupt.se.ttms.dao.IreporttypeDao;
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
}
