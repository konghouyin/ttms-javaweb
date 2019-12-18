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


@WebServlet("/managerselect")
public class managerselect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("managerselect");
		usermodify Messselect = new usermodify();
		String userid = String.valueOf( request.getSession().getAttribute("userId"));
		User people = Messselect.userGetById(userid);
		System.out.println(people);
		
		backMessage JSONobj1 = new backMessage(1, "查询成功", people);
		
		String bString = JSON.toJSONString(JSONobj1);
		response.getWriter().println(bString);
			

}
	}
