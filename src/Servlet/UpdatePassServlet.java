package Servlet;

import Bean.UpdatePassBean;
import Demo.UpdatePass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/2/3.
 */
@WebServlet(name = "UpdatePassServlet")
public class UpdatePassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/text; charset=utf-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        String oldPass = request.getParameter("oldPass");
        String newPass = request.getParameter("newPass");

        UpdatePassBean updatePassBean = new UpdatePassBean(username,oldPass,newPass);

        UpdatePass updatePass = new UpdatePass(updatePassBean);
        if(updatePass.checkOldPass()) {
            if(updatePass.updateNewPass())
                out.write("success");
            else
                out.write("updateFail");
        } else out.write("checkFail");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
