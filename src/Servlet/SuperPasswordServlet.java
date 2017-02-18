package Servlet;

import Util.CreateMD5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/2/18.
 * 验证超级密码
 */
@WebServlet(name = "SuperPasswordServlet")
public class SuperPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/text; charset=utf-8");
        PrintWriter out = response.getWriter();

        String myPass = CreateMD5.getMd5("302711");
        String pass = request.getParameter("pass");
        if(CreateMD5.getMd5(pass).equals(myPass))
            out.write("true");
        else out.write("false");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
