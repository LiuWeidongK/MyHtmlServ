package Servlet;

import Demo.Delete;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/2/8.
 * 单体删除 Servlet
 */
@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/text; charset=utf-8");
        PrintWriter out = response.getWriter();

        String FacId = request.getParameter("facid");

        Delete delete = new Delete(FacId);

        if(delete.doIt())
            out.write("success");
        else out.write("fail");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
