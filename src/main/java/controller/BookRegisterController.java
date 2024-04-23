package controller;

import entity.Book;
import repository.BookDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class BookRegisterController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
                                                           throws ServletException, IOException {
            req.setCharacterEncoding("UTF-8");
             // title, price, author, page : 폼 파라메터  -> (받아서, DTO 담아) : 파라메터수집(*) ->  자동
            String title=req.getParameter("title");
            int price=Integer.parseInt(req.getParameter("price")); // "50000"->50000
            String author=req.getParameter("author");
            int page=Integer.parseInt(req.getParameter("page")); // "50000"->50000
            Book dto=new Book();
            dto.setTitle(title);
            dto.setPrice(price);
            dto.setAuthor(author);
            dto.setPage(page);

            BookDAO dao=new BookDAO();
            int cnt=dao.bookRegister(dto);
            // 성공 -> 다시 리스트페이지로 가기
            // 실패-> 예외 발생
    }
}
