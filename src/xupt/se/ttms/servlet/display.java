package xupt.se.ttms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import xupt.se.ttms.domain.Play;
import xupt.se.ttms.domain.User;
import xupt.se.ttms.domain.backMessage;
import xupt.se.ttms.service.displayService;
import xupt.se.ttms.service.userService;

@WebServlet("/display")
public class display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		displayService playService = new displayService();
		List<Play> alist=playService.getallplay();
		System.out.println(alist);
		if (alist == null) {
			backMessage JSONobj = new backMessage(-1, "数据库中无影片", null);
			String aString = JSON.toJSONString(JSONobj);
			response.getWriter().println(aString);
		} else {
			backMessage JSONobj = new backMessage(1, "注册成功", alist);
			String aString = JSON.toJSONString(JSONobj);
			response.getWriter().println(aString);
		}
	}

}
