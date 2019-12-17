package xupt.se.ttms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;

import xupt.se.ttms.service.cinemaService;
import xupt.se.ttms.service.userService;
import xupt.se.ttms.domain.Cinema;
import xupt.se.ttms.domain.User;
import xupt.se.ttms.domain.backMessage;

@WebServlet("/cinemaAdd")
public class cinemaAdd extends HttpServlet{
	private static final long serialVersionUID = 3L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String roomName = request.getParameter("roomname");
		String roomRow = request.getParameter("roomrow");
		String roomCol = request.getParameter("roomcol");
		String roomStatus = request.getParameter("roomstatus");
		String seatArr = request.getParameter("seat");
		cinemaService Service = new cinemaService();
		int back = Service.cinemaAdd(roomName, roomRow, roomCol, roomStatus,seatArr);		
		backMessage JSONobj = new backMessage(1, "添加成功", back);
		String aString = JSON.toJSONString(JSONobj);
		response.getWriter().println(aString);
		
	}
}
