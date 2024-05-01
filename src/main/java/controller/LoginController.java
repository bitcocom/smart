package controller;

import entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import repository.BookMapper;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private BookMapper mapper;

    @PostMapping("/login")   // username, password
     public String  login(Member member, HttpSession session){
            if(member.getUsername().equals("admin") &&
                    member.getPassword().equals("admin") ){ // 인증에 성공한 경우 -> 객체바인딩(HttpSession)
                    Member dbmem=new Member();
                    dbmem.setUsername(member.getUsername()); //  admin
                    dbmem.setName("관리자");
                    dbmem.setEmail("bit@aaa.ac.kr");
                    session.setAttribute("dbmem", dbmem); // 객체 바인딩  ${!empty dbmem}  -> ${dbmem.name}
            }
            return "redirect:/bookList";  // 로그인 화면이 있는 시작페이지
    }

    @PostMapping("/logout")
    public String logout(HttpSession session){
          session.invalidate(); // 세션 끊기
          return "redirect:/bookList";
    }
}
