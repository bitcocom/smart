package controller;

import entity.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/bookList")
public class BookListController extends HttpServlet {
     // GET --> doGet()  @GetMapping()
    // POST -->doPost() @PostMapping()
    // service
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         // Database에서 책목록을 가져오기 :  List -> ArrayList
        List<Book> list=new ArrayList<Book>();
        list.add(new Book(1,"자바1", 12000,"홍길동", 500));
        list.add(new Book(2,"자바2", 13000,"박길동", 600));
        list.add(new Book(3,"자바3", 14000,"이길동", 700));
        req.setAttribute("list", list); // 객체바인딩(중요)
        //  View(JSP)와 연동하기(forward, dispatcher)
        // 요청의뢰객체(RequestDispatcher)를 얻어오는 방법
        RequestDispatcher rd =req.getRequestDispatcher("/WEB-INF/views/list.jsp");
        rd.forward(req, resp);  //----------------list---------------------|
    }
}
