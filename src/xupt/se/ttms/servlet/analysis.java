package xupt.se.ttms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import xupt.se.ttms.domain.backMessage;
import xupt.se.ttms.service.displayService;


@WebServlet("/analysis")
public class analysis extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getParameter("path");
		displayService playService = new displayService();
		JSONObject aJsonObject = playService.analysisIndex(playService.analysisPath(path));
		if(aJsonObject==null) {
			backMessage JSONobj = new backMessage(-1, "解析错误", null);
			response.getWriter().println(JSON.toJSONString(JSONobj));
		}else {
			backMessage JSONobj = new backMessage(1, "解析成功", aJsonObject);
			response.getWriter().println(JSON.toJSONString(JSONobj));
		}
	}
}
