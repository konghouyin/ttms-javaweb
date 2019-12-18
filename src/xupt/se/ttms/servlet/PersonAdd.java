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

@WebServlet("/PersonAdd")
public class PersonAdd extends HttpServlet {
    private static final long serialVersionUID = 2L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("pass");
        String phemail=request.getParameter("phemail");
        String status=request.getParameter("status");

        System.out.println(userName);
        userService registerService = new userService();
        User backUser = registerService.personadd(userName, password,phemail,status);

        if (backUser == null) {
            backMessage JSONobj = new backMessage(-1, "添加失败", null);
            System.out.println(JSON.toJSONString(JSONobj));
            response.getWriter().println(JSON.toJSONString(JSONobj));
        } else {
            backMessage JSONobj = new backMessage(1, "添加成功", backUser);
            response.getWriter().println(JSON.toJSONString(JSONobj));

        }
    }

}