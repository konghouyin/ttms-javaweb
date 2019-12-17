package xupt.se.ttms.servlet;

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

    }
}
