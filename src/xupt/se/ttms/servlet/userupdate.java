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
import xupt.se.ttms.service.usermodify;

/**
 * Servlet implementation class userupdate
 */
@WebServlet("/usermodify")
public class userupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String tel = request.getParameter("tel");
		String status = request.getParameter("status");
		System.out.println(userName);
		usermodify UserService = new usermodify();
		User person = new User();
		//person.setUser_id((Integer) request.getSession().getAttribute("userId"));
		person.setUser_id((40));
		person.setUser_name(userName);
		person.setUser_password(password);
		person.setUser_tel(tel);
		person.setUser_sex((2));
		person.setUser_mail(("1231"));
		person.setUser_age((123));
		person.setUser_status(status);
		UserService.userUpdate(person);
		
		backMessage JSONobj = new backMessage(1, "修改成功", person);
		String aString = JSON.toJSONString(JSONobj);
		response.getWriter().println(aString);
		
	}

}
