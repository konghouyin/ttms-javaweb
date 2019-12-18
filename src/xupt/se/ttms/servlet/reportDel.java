package xupt.se.ttms.servlet;

import com.alibaba.fastjson.JSON;
import xupt.se.ttms.domain.backMessage;
import xupt.se.ttms.service.commentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: ttms-javaweb
 * @author: WolfSky
 * @create: 2019-12-18 17:59
 **/
@WebServlet("/report/del")
public class reportDel extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String comment_id = req.getParameter("comment_id");
        int id = Integer.valueOf(comment_id);

        try{
            commentService service = new commentService();
            service.overdule(id,3);
            backMessage JSONobj = new backMessage(1, "被举报评论删除成功", 1);
            resp.getWriter().println(JSON.toJSONString(JSONobj));
        }catch (Exception e){
            e.printStackTrace();
            backMessage JSONobj = new backMessage(-1, "被举报评论删除失败", 1);
            resp.getWriter().println(JSON.toJSONString(JSONobj));
        }
    }
}
