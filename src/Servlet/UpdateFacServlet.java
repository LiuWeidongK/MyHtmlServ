package Servlet;

import Bean.UpdateFacBean;
import Demo.UpdateFac;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/2/7.
 */
@WebServlet(name = "UpdateFacServlet")
public class UpdateFacServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/text; charset=utf-8");
        PrintWriter out = response.getWriter();

        String labNo = request.getParameter("upinputLabNo");
        String facNo = request.getParameter("upinputFacNo");
        String facName = request.getParameter("upinputFacName");
        String facMod = request.getParameter("upinputFacMod");
        String stock = request.getParameter("upStock");
        int intStock = Integer.parseInt(stock);

        UpdateFacBean updateFacBean = new UpdateFacBean(labNo,facNo,facName,facMod,intStock);

        UpdateFac updateFac = new UpdateFac(updateFacBean);

        if(updateFac.updateValue())
            out.write("success");
        else out.write("fail");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
