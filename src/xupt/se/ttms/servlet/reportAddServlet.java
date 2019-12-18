package xupt.se.ttms.servlet;

import com.alibaba.fastjson.JSON;
import xupt.se.ttms.domain.backMessage;
import xupt.se.ttms.service.commentService;
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
//        String playId = req.getParameter("playid");
        String comment_id = req.getParameter("id");
        String type = req.getParameter("type");
        String msg = req.getParameter("msg");


        Integer userid = (Integer) req.getSession().getAttribute("userId");
        System.out.println(req.getSession().getAttribute("userId"));

        try{
            reportService service = new reportService();
            commentService commentService = new commentService();


            int reportTypeId = service.getReportTypeId(type);
            System.out.println(reportTypeId);

            int i = service.addReport(Integer.valueOf(comment_id), userid, reportTypeId, msg, 1);
            System.out.println(i);
            commentService.update(Integer.valueOf(comment_id));
            backMessage JSONobj = new backMessage(1, "举报添加成功", "1");
            String aString = JSON.toJSONString(JSONobj);
            resp.getWriter().println(aString);
        }catch (Exception e){
            e.printStackTrace();
            backMessage JSONobj = new backMessage(-1, "举报添加失败成功", "-1");
            String aString = JSON.toJSONString(JSONobj);
            resp.getWriter().println(aString);
        }


    }
}
