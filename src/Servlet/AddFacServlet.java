package Servlet;

import Bean.AddFacBean;
import Demo.AddFac;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/2/5.
 */
@WebServlet(name = "AddFacServlet")
public class AddFacServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/text; charset=utf-8");
        PrintWriter out = response.getWriter();

        String LabNo = request.getParameter("addLabNo");
        String FacNo = request.getParameter("addFacNo");
        String FacName = request.getParameter("addFacName");
        String FacMod = request.getParameter("addFacMod");
        int HaveNum = Integer.parseInt(request.getParameter("addHaveNum"));
        String DataInfo = request.getParameter("addDataInfo");

        AddFacBean addFacBean = new AddFacBean(LabNo,FacNo,FacName,FacMod,HaveNum,DataInfo);

        AddFac addFac = new AddFac(addFacBean);

        if(addFac.checkRehava()){
            if(addFac.insertValue())
                out.write("success");
            else out.write("insertFail");
        } else out.write("repeatFail");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
