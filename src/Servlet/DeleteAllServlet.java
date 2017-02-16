package Servlet;

import Bean.BorrowBean;
import Demo.Delete;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/2/11.
 * 批量删除 Servlet
 */
@WebServlet(name = "DeleteAllServlet")
public class DeleteAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/text; charset=utf-8");
        PrintWriter out = response.getWriter();

        String facListStr = request.getParameter("facList");
        List<String> facList = Arrays.asList(facListStr.split(","));

        boolean sign = true;
        List<Boolean> result = new ArrayList<>();
        for(String id:facList) {
            Delete delete = new Delete(id);
            boolean r = delete.doIt();
            result.add(r);
        }
        for(boolean i:result) {
            if(!i)
                sign = false;
        }

        if(sign)
            out.write("success");
        else out.write("fail");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
