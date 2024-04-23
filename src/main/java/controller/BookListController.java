package controller;

import entity.Book;
import repository.BookDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
// http://localhost:8081/weberp/bookList
@WebServlet("/bookList")
public class BookListController extends HttpServlet {
     // GET --> doGet()  @GetMapping()
    // POST -->doPost() @PostMapping()
    // service
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         // Database(DAO)에서 책목록을 가져오기 :  List -> ArrayList
        BookDAO dao=new BookDAO();
        List<Book> list=dao.bookList();
        req.setAttribute("list", list); // 객체바인딩(중요)
        //  "list"---->list(번지값)
        //  View(JSP)와 연동하기(forward, dispatcher)
        // 요청의뢰객체(RequestDispatcher)를 얻어오는 방법
        RequestDispatcher rd =req.getRequestDispatcher("/WEB-INF/views/list.jsp");
        rd.forward(req, resp);  //----------------list---------------------|
    }
}
