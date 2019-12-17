package xupt.se.ttms.servlet;

import com.alibaba.fastjson.JSON;
import xupt.se.ttms.domain.backMessage;
import xupt.se.ttms.service.reportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program: ttms-javaweb
 * @author: WolfSky
 * @create: 2019-12-17 15:26
 **/
@WebServlet("/reportType/getreportType")
public class repTypeServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        reportService reportService = new reportService();
        List<String> reportTypeBySta = reportService.getReportTypeBySta();
        System.out.println(reportTypeBySta);

        backMessage JSONobj = new backMessage(1, "查找成功", reportTypeBySta);
        String aString = JSON.toJSONString(JSONobj);
        resp.getWriter().println(aString);
    }
}
