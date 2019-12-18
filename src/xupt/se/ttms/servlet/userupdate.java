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
		String userid = String.valueOf( request.getSession().getAttribute("userId"));
		User p = UserService.userGetById(userid);
		int sex = p.getUser_sex();
		int age = p.getUser_age();
		String mail = p.getUser_mail();
		int user_id = Integer.parseInt(userid);
		person.setUser_id(user_id);
		person.setUser_name(userName);
		person.setUser_password(password);
		person.setUser_tel(tel);
		person.setUser_sex(sex);
		person.setUser_mail(mail);
		person.setUser_age(age);
		person.setUser_status(status);
		UserService.userUpdate(person);
		
		backMessage JSONobj = new backMessage(1, "修改成功", person);
		String aString = JSON.toJSONString(JSONobj);
		response.getWriter().println(aString);
		
	}

}
