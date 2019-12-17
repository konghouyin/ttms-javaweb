package xupt.se.ttms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import xupt.se.ttms.domain.User;
import xupt.se.ttms.domain.backMessage;
import xupt.se.ttms.service.userService;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 2L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(userName);
		userService registerService = new userService();
		User backUser = registerService.login(userName, password);
		
		if (backUser == null) {
			backMessage JSONobj = new backMessage(-1, "用户名或密码错误", null);
			System.out.println(JSON.toJSONString(JSONobj));
			response.getWriter().println(JSON.toJSONString(JSONobj));
		} else {
			request.getSession().setAttribute("userId", backUser.getUser_id());
			request.getSession().setAttribute("userStatus", backUser.getUser_status());
			backMessage JSONobj = new backMessage(1, "登录成功", backUser);
			response.getWriter().println(JSON.toJSONString(JSONobj));
		}
	}
}