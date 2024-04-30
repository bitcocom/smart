package controller;

import entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.BookMapper;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookRestController { //   jackson-databind(Object->JSON)

    @Autowired
    private BookMapper mapper;

    // GET : http://localhost:8081/weberp/api/books :  책 전체리스트 보기 <--요청이 오면
    // 결과 : JSON(구조?) 설명 --> REST API 명세서
    @GetMapping("/books")
    public ResponseEntity<?> list(){
        List<Book> list=mapper.bookList();
        return new ResponseEntity<>(list, HttpStatus.OK);  // 200,  Data(JSON)와 응답상태코드를 함께 리턴하는 객체
    }

    @DeleteMapping("/books/{num}")
    public  ResponseEntity<?> delete(@PathVariable int num){
           mapper.bookDelete(num); // 성공
           HttpHeaders headers = new HttpHeaders();
           headers.setContentType(new MediaType("text", "plain", StandardCharsets.UTF_8));
           return new ResponseEntity<>("성공", headers, HttpStatus.OK); // 200OK ??
    }
    // 등록
    // POST : http://localhost:8081/weberp/api/books
    @PostMapping("/books") // <-- { "title":"DB", price, author, page } : <form - X> : JSON
    public ResponseEntity<?> register(@RequestBody Book book){
        int cnt=mapper.bookRegister(book);
        return new ResponseEntity<>(cnt, HttpStatus.OK);
    }
   // 상세보기
    // GET : http://localhost:8081/weberp/api/books/{id}  :  id : 책의고유한 번호
    @GetMapping("/books/{num}") //
    public ResponseEntity<?> getByNum(@PathVariable int num){ // 0
        Book book=mapper.getByNum(num);
        return new ResponseEntity<>(book, HttpStatus.OK);  // {       }
    }
    // POST : http://localhost:8081/weberp/api/books  : <---JSON
    // 수정하기
    // PUT : http://localhost:8081/weberp/api/books/{id} : 책수정하기 <---JSON
    @PutMapping("/books/{num}")
    public ResponseEntity<?> update(@PathVariable int num, @RequestBody Book book){
         //book.setNum(num);
         mapper.bookUpdate(num, book);
         return new ResponseEntity<>("성공", HttpStatus.OK);
    }
}
/*
   HttpSession(세션)---> : 인증/권한 : Spring Security

 */