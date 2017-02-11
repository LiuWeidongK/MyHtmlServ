package Servlet;

import Bean.LoginBean;
import Demo.JsonStr;
import Util.Json;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/2/9.
 */
@WebServlet(name = "JsonServlet")
public class JsonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/text; charset=utf-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        int No = Integer.parseInt(request.getParameter("No"));

        JsonStr jsonStr = new JsonStr(No,username);

        String json = jsonStr.jsonV();
        out.write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
