package controller;

import service.MyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc")
public class CalcController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
                                                                                                   throws ServletException, IOException {
              // 클라이언트 폼에서 넘어온 파라메터(su1, su2)를 얻기(가져오기)  : get~~~
              int su1=Integer.parseInt(req.getParameter("su1")); // "50" --> 50
              int su2=Integer.parseInt(req.getParameter("su2"));
              int sum=MyService.hap(su1, su2);
                resp.setContentType("text/html;charset=UTF-8");  // MIME Type
                // 클라이언트에 응답할 출력 스트림(빨대)을 만들어야 한다.
                PrintWriter out=resp.getWriter();
                out.println("<html>");
                out.println("<body>");
                out.println("<table border='1'>");
                out.println("<tr>");
                out.println("<td>총합</td>");
                out.println("<td>"+sum+"</td>");
                out.println("</tr>");
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
    }
}
