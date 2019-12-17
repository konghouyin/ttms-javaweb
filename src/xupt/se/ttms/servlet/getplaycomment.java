package xupt.se.ttms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import xupt.se.ttms.domain.Comment;
import xupt.se.ttms.domain.Play;
import xupt.se.ttms.domain.backMessage;
import xupt.se.ttms.service.displayService;

@WebServlet("/getplaycomment")
public class getplaycomment extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String playid = request.getParameter("playid");
		
		commentService commentService = new commentService();
		List<Comment> playcomment=commentService.getplaycomment(playid);
		System.out.println(playcomment);
		
		if (playcomment == null) {
			backMessage JSONobj = new backMessage(-1, "数据库中无评论", null);
			String aString = JSON.toJSONString(JSONobj);
			response.getWriter().println(aString);
		} else {
			backMessage JSONobj = new backMessage(1, "获取评论成功", playcomment);
			String aString = JSON.toJSONString(JSONobj);
			response.getWriter().println(aString);
		}
	}

}
