package xupt.se.ttms.servlet;

import java.io.Console;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import xupt.se.ttms.domain.User;
import xupt.se.ttms.domain.backMessage;
import xupt.se.ttms.service.displayService;
import xupt.se.ttms.service.userService;

@WebServlet("/addplay")
public class addplay extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getParameter("path");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String director = request.getParameter("director");
		String performer = request.getParameter("performer");
		String length = request.getParameter("length");
		String country = request.getParameter("country");
		String language = request.getParameter("language");
		String status = request.getParameter("status");
		String pic = request.getParameter("pic");
		String link = request.getParameter("link");
		String comment = request.getParameter("comment");
		
		displayService playService = new displayService();
		Object pathDataObject = playService.analysisPath(path);
		String message = "";
		if ((boolean) pathDataObject) {
			message = pathDataObject.toString();
		}

		int back = playService.addPlay(path, name, type, director, performer, length, country, language, status, pic, link, comment, message);
		System.out.println(back);
		
		if(comment.equals("true") && back!=0 && message.length()>500) {
			playService.addCommentByPath(message,back);
		}
		
		
		if (back == 0) {
			backMessage JSONobj = new backMessage(-1, "影片添加失败", null);
			response.getWriter().println(JSON.toJSONString(JSONobj));
		} else {
			backMessage JSONobj = new backMessage(1, "影片添加成功", 1);
			response.getWriter().println(JSON.toJSONString(JSONobj));
		}
	}
}
