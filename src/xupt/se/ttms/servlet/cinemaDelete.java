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

@WebServlet("/cinemaDelete")
public class cinemaDelete extends HttpServlet{
	private static final long serialVersionUID = 5L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String roomID = request.getParameter("room_id");
		cinemaService Service = new cinemaService();
		int back =  Service.cinemaDelete(Integer.valueOf(roomID));		
		backMessage JSONobj = new backMessage(1, "删除成功", back);
		String aString = JSON.toJSONString(JSONobj);
		response.getWriter().println(aString);

	}
}
