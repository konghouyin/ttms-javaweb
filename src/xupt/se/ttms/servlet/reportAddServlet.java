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
 * @create: 2019-12-17 22:04
 **/
@WebServlet("/report/add")
public class reportAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String comment_id = req.getParameter("id");
        String type = req.getParameter("type");
        String msg = req.getParameter("msg");

        Integer userid = 40;

        try{
            reportService service = new reportService();
            int reportTypeId = service.getReportTypeId(type);
            service.addReport(Integer.valueOf(comment_id),userid,reportTypeId,msg,1);
            backMessage JSONobj = new backMessage(1, "举报添加成功", "1");
            String aString = JSON.toJSONString(JSONobj);
            resp.getWriter().println(aString);
        }catch (Exception e){
            backMessage JSONobj = new backMessage(-1, "举办添加失败成功", "-1");
            String aString = JSON.toJSONString(JSONobj);
            resp.getWriter().println(aString);
        }


    }
}
