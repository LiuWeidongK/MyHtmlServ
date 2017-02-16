package Servlet;

import Bean.LoginBean;
import Demo.Login;
import Util.CreateMD5;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/2/9.
 * 登录的Servlet
 */
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("application/text; charset=utf-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        LoginBean loginBean = new LoginBean(username, CreateMD5.getMd5(password));
        Login login = new Login(loginBean);
        if(login.select()) {
            request.getSession().setAttribute("username",username);
            request.getSession().setMaxInactiveInterval(60*60);
            out.write("true");
        } else {
            out.write("false");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
