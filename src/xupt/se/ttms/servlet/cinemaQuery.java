package xupt.se.ttms.servlet;

import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import xupt.se.ttms.domain.Cinema;
import xupt.se.ttms.domain.backMessage;
import xupt.se.ttms.service.cinemaService;

@WebServlet("/cinemaQuery")
public class cinemaQuery extends HttpServlet{
	private static final long serialVersionUID = 4L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		cinemaService Service = new cinemaService();
		List<Cinema> back =  Service.cinemaQuery();		
		backMessage JSONobj = new backMessage(1, "查询成功", back);
		String aString = JSON.toJSONString(JSONobj);
		response.getWriter().println(aString);
	}
}
