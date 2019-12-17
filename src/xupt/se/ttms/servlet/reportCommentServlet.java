package xupt.se.ttms.servlet;

import xupt.se.ttms.domain.ReportComment;
import xupt.se.ttms.service.commentService;

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
 * @create: 2019-12-17 21:27
 **/
@WebServlet("/report/comment")
public class reportCommentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        commentService service = new commentService();

        List<ReportComment> commentByStatus = service.getCommentByStatus();
        System.out.println(commentByStatus);
    }
}
