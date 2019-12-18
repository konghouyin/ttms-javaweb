package xupt.se.ttms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.sun.xml.internal.ws.wsdl.writer.document.Service;

import xupt.se.ttms.domain.User;
import xupt.se.ttms.domain.backMessage;
import xupt.se.ttms.service.userMService;


/**
 * Servlet implementation class usermessage
 */
@WebServlet("/usermessage")
public class usermessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			
		String userName = request.getParameter("username");
		String resource = request.getParameter("sex");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String age = request.getParameter("age");
		System.out.println(userName);
		userMService MessService = new userMService();
		int sex = Integer.parseInt(resource);
		int userage = Integer.parseInt(age);
		User person = new User();
		String userid = (String) request.getSession().getAttribute("userId");
		int user_id = Integer.parseInt(userid);
		User p = MessService.userGetById(userid);
		String status = p.getUser_status();
		person.setUser_id(user_id);
		person.setUser_name(userName);
		person.setUser_sex(sex);
		person.setUser_status(status);
		person.setUser_tel(tel);
		person.setUser_mail(email);
		person.setUser_age(userage);
		MessService.userUpdate(person);
		
		backMessage JSONobj = new backMessage(1, "修改成功", person);
		String aString = JSON.toJSONString(JSONobj);
		response.getWriter().println(aString);
		
	}


	
}
