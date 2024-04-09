package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// javase ->API(List, Map, Set ~~) :  JDK
// javaee ->API 필요하다?
public class HelloServlet extends HttpServlet {  // Servlet(서버에서 100% 자바로 만들어진 웹프로그래밍)
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           // <html> tag를 이용해서 응답 코드 작성

    }
}
