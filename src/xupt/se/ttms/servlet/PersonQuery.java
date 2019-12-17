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
import xupt.se.ttms.service.userService;

@WebServlet("/PersonQuery")
public class PersonQuery extends HttpServlet {
    private static final long serialVersionUID = 2L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userService registerService = new userService();
    }

}