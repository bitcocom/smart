package controller;

import com.sun.net.httpserver.HttpServer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerUI")
public class BookRegisterUIController extends HttpServlet {  // Controller->DispatcherServlet(FrontController)
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
                                                                       throws ServletException, IOException {
           // 등록 페이지로 이동(jsp) : froward
        RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/views/register.jsp");
        rd.forward(req,resp);
    }
}
