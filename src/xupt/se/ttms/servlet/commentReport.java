package xupt.se.ttms.servlet;

import com.alibaba.fastjson.JSON;
import xupt.se.ttms.domain.Reporttype;
import xupt.se.ttms.domain.backMessage;
import xupt.se.ttms.service.reportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: ttms-javaweb
 * @author: WolfSky
 * @create: 2019-12-16 23:14
 **/
@WebServlet("/comment/report")
public class commentReport extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
//        String msg = req.getParameter("msg");


        reportService reportService = new reportService();
        reportService.repTypeAdd(type);
        System.out.println(type);
//        System.out.println(msg);
        backMessage JSONobj = new backMessage(1, "添加成功",null);
        String aString = JSON.toJSONString(JSONobj);
        System.out.println(aString);
        resp.getWriter().println(aString);
    }
}
