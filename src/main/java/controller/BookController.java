package controller;

import entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import repository.BookDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BookController{ // new BookController() ; Spring Container(객체가 관리되는 메모리 공간)
    // 책과 관련된 일을 하는 컨트롤러
    // /bookList(요청,핸들) --- FC ---> HandlerMapping :  POJO 연결
    // http://localhost:8081/weberp/bookList
    @RequestMapping("/bookList")
    public String list(Model model){
        // 책리스트 가져오기
        // View : list.jsp
        BookDAO dao=new BookDAO();
        List<Book> list=dao.bookList();
        model.addAttribute("list", list);

        return "list"; // View의 논리적인 이름 : list.jsp :  ${   } : forward
    }
    @GetMapping("/register") // GET - 등록화면
     public String registerGET(){
         return "register"; //  register.jsp : forward
    }
    @PostMapping("/register") // POST- 등록 ;
    public String registerPOST(Book book){
        BookDAO dao=new BookDAO();
        dao.bookRegister(book); // 등록
        // 등록이 성공 다시 리스트로 가기 ? redirect
        return "redirect:/bookList"; // /weberp/bookList
    }
}
