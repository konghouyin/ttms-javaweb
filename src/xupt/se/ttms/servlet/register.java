package xupt.se.ttms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;
import xupt.se.ttms.service.userService;
import xupt.se.ttms.domain.User;
import xupt.se.ttms.domain.backMessage;

@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		userService registerService = new userService();
		User backUser = registerService.register(userName, password);
		if (backUser == null) {
			backMessage JSONobj = new backMessage(-1, "数据库中已经存在该用户名", null);
			String aString = JSON.toJSONString(JSONobj);
			response.getWriter().println(aString);
		} else {
			request.getSession().setAttribute("userId", backUser.getUser_id());
			request.getSession().setAttribute("userStatus", backUser.getUser_status());
			backMessage JSONobj = new backMessage(1, "注册成功", backUser);
			String aString = JSON.toJSONString(JSONobj);
			response.getWriter().println(aString);
		}
	}
}
