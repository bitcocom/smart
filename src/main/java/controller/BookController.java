package controller;

import entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import repository.BookMapper;

import java.util.List;

@Controller
public class BookController{ // new BookController() ; Spring Container(객체가 관리되는 메모리 공간)
    // 책과 관련된 일을 하는 컨트롤러
    // /bookList(요청,핸들) --- FC ---> HandlerMapping :  POJO 연결
    //
    @Autowired  // DI(의존성주입)
    private BookMapper  mapper;
    @RequestMapping("/bookList")
    public String list(Model model){
        List<Book> list=mapper.bookList();
        model.addAttribute("list", list);
        return "list"; // View의 논리적인 이름 : list.jsp :  ${   } : forward
    }

    @RequestMapping("/bookJson")
    public @ResponseBody List<Book> list(){
        List<Book> list=mapper.bookList();
        return list; // list->jackson-databind->[ {      }, {      }, {      } ]  ---------------> 응답
    }

    @GetMapping("/register") // GET - 등록화면
     public String registerGET(){
         return "register"; //  register.jsp : forward
    }
    @PostMapping("/register") // POST- 등록 ;
    public String registerPOST(Book book){
        mapper.bookRegister(book);
        return "redirect:/bookList"; // /weberp/bookList
    }
    @GetMapping("/remove/{num}")   // /remove/1
    public String remove(@PathVariable int num){
         mapper.bookDelete(num);
         // 삭제 성공후 다시 리스트 페이지로... redirect
        return "redirect:/bookList";
    }
}
/*
  RESTful Service
  1. GET : @GetMapping
  2. POST : @PostMapping
  3. PUT : @PutMapping
  4. DELETE : @DeleteMapping
 - ajax( method : "DELETE" , url="http://localhost:8081/weberp/remove/1")
 - fetch()

 */