package xupt.se.ttms.servlet;

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
@WebServlet("/cinemaUpdate")
public class cinemaUpdate extends HttpServlet{
	private static final long serialVersionUID = 6L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomId = request.getParameter("roomid");
		String roomName = request.getParameter("roomname");
		String roomRow = request.getParameter("roomrow");
		String roomCol = request.getParameter("roomcol");
		String roomStatus = request.getParameter("roomstatus");
		String seatArr = request.getParameter("seat");
		cinemaService Service = new cinemaService();
		Cinema back = Service.cinemaUpdate(roomId, roomName, roomRow, roomCol, roomStatus,seatArr);
		if (back == null) {
			backMessage JSONobj = new backMessage(-1, "修改失败", null);
			String aString = JSON.toJSONString(JSONobj);
			response.getWriter().println(aString);
		} else {
			backMessage JSONobj = new backMessage(1, "修改成功", back);
			String aString = JSON.toJSONString(JSONobj);
			response.getWriter().println(aString);
		}
	}
}
