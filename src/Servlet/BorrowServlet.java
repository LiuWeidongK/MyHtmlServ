package Servlet;

import Bean.BorrowBean;
import Demo.Borrow;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/2/6.
 */
@WebServlet(name = "BorrowServlet")
public class BorrowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/text; charset=utf-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String sUseLong = request.getParameter("UseDate");
        String borrowFacId = request.getParameter("borrowFacID");
        System.out.print(borrowFacId);
        int useLong;
        if(sUseLong.isEmpty()) {
            out.write("fail");
            return;
        }
        else {
            useLong = Integer.parseInt(sUseLong);
        }
        String useAim = request.getParameter("UseAim");

        BorrowBean borrowBean = new BorrowBean(username,date,useLong,useAim,borrowFacId);

        Borrow borrow = new Borrow(borrowBean);

        if(borrow.doIt())
            out.write("success");
        else out.write("fail");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
