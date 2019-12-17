package xupt.se.ttms.servlet;

import com.alibaba.fastjson.JSON;
import xupt.se.ttms.domain.Comment;
import xupt.se.ttms.domain.backMessage;
import xupt.se.ttms.service.commentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: ttms-javaweb
 * @author: WolfSky
 * @create: 2019-12-16 19:39
 **/
@WebServlet("/comment/add")
public class commentAdd extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String comment_msg = req.getParameter("text");
        String grade = req.getParameter("grade");
        System.out.println(comment_msg);
        System.out.println(grade);

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //从前端或者自己模拟一个日期格式，转为String即可
        String dateStr = format.format(date);
        Comment comment = new Comment();


        if("".equals(comment_msg)){
            backMessage JSONobj = new backMessage(-1, "添加失败", "");
            resp.getWriter().println(JSON.toJSONString(JSONobj));
        }else {
            commentService service = new commentService();
            comment.setUser_id(40);
            comment.setComment_message(comment_msg);
            comment.setComment_grade(Integer.valueOf(grade));
            comment.setComment_status(1);
            comment.setPlay_id(1);
            comment.setComment_time(dateStr);
            service.commentAdd(comment);
            backMessage JSONobj = new backMessage(1, "添加成功", comment);
            String aString = JSON.toJSONString(JSONobj);
            System.out.println(aString);
            resp.getWriter().println(aString);
        }
    }
}
