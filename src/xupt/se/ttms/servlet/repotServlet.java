package xupt.se.ttms.servlet;

import com.alibaba.fastjson.JSON;
import xupt.se.ttms.domain.ReportComment;
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
 * @create: 2019-12-18 00:46
 **/
@WebServlet("/report/comment")
public class repotServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        reportService service = new reportService();
        List<ReportComment> reports = service.reports();

        System.out.println(reports);
        backMessage JSONobj = new backMessage(1, "查找举报评论成功", reports);
        String aString = JSON.toJSONString(JSONobj);
        resp.getWriter().println(aString);
    }
}
