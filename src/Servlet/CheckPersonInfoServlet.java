package Servlet;

import Demo.CheckPersonInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/2/11.
 */
@WebServlet(name = "CheckPersonInfoServlet")
public class CheckPersonInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/text; charset=utf-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");

        CheckPersonInfo checkPersonInfo = new CheckPersonInfo(username);
        if(checkPersonInfo.checkInfo()) {
            out.write("success");
        }
        else out.write("fail");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
