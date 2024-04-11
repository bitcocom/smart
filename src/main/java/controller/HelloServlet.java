package controller;

import service.MyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// javase ->API(List, Map, Set ~~) :  JDK
// javaee ->API 필요하다?
@WebServlet("/hello") // Servlet Mapping
public class HelloServlet extends HttpServlet {  // Servlet(서버에서 100% 자바로 만들어진 웹프로그래밍)
    @Override                    //   요청객체                                      //응답객체
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           // <html> tag를 이용해서 응답 코드 작성
           // 1~10까지의 총합이=?
           // 1. 직접구한다. 2. 별도의 클래스에서 처리한다.(O)
           // 객체생성
           int hap=MyService.hap();
           // 응답시 한글 깨짐 처리
           resp.setContentType("text/html;charset=UTF-8");  // MIME Type
           // 클라이언트에 응답할 출력 스트림(빨대)을 만들어야 한다.
           PrintWriter out=resp.getWriter();
           out.println("<html>");
           out.println("<body>");
           out.println("<table border='1'>");
           out.println("<tr>");
           out.println("<td>총합</td>");
           out.println("<td>"+hap+"</td>");
          out.println("</tr>");
           out.println("</table>");
           out.println("</body>");
           out.println("</html>");

    }
}