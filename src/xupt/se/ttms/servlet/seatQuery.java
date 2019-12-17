package xupt.se.ttms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import xupt.se.ttms.domain.Cinema;
import xupt.se.ttms.domain.backMessage;
import xupt.se.ttms.service.cinemaService;

@WebServlet("/seatQuery")
public class seatQuery extends HttpServlet{
	private static final long serialVersionUID = 7L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String roomId = request.getParameter("roomid");
		cinemaService Service = new cinemaService();
		Cinema back =  Service.cinemaQueryOne(roomId);		
		backMessage JSONobj = new backMessage(1, "查询成功1", back);
		String aString = JSON.toJSONString(JSONobj);
		response.getWriter().println(aString);
	}
}
