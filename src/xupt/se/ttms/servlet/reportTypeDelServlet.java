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

/**
 * @program: ttms-javaweb
 * @author: WolfSky
 * @create: 2019-12-17 16:12
 **/
@WebServlet("/reportType/del")
public class reportTypeDelServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        reportService service = new reportService();
        try {
            service.delreportType(name);
        }catch (Exception e){
            backMessage JSONobj = new backMessage(-1, "删除失败", null);
            String aString = JSON.toJSONString(JSONobj);
            resp.getWriter().println(aString);
            e.printStackTrace();
        }
        backMessage JSONobj = new backMessage(1, "删除成功", null);
        String aString = JSON.toJSONString(JSONobj);
        resp.getWriter().println(aString);
    }
}
