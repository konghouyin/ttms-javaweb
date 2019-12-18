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
		
		if("".equals(comment_msg)){
            backMessage JSONobj = new backMessage(-1, "评论内容为空", "");
            resp.getWriter().println(JSON.toJSONString(JSONobj));
        }else {
        	commentService service = new commentService();
			Object userId = req.getSession().getAttribute("userId");
			int id = Integer.valueOf((String) userId);
			int comment = service.commentAdd(comment_msg, grade,1,id);
    		//后期替换两个参数
    		
    		backMessage JSONobj = new backMessage(1, "添加成功", comment);
    		String aString = JSON.toJSONString(JSONobj);
    		resp.getWriter().println(aString);
        }
	}
}
