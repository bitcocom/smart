package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController { // 경로만 변경시키는 컨트롤러

      // 책 리스트 보기
    @GetMapping("/restlist")
    public String restlist(){
         // 1. 책리스트를 가져와야 된다... http://localhost:8081/weberp/api/books
         // 날씨정보를 ? Open API(URL ? ) 연결----->날씨 데이터 받아온다(JSON) -> 파싱
        // 객체바인딩
        // JSP
        // 고객주소 --> 위도, 경도 : Map OpenAPI(URL ?) 연결---주소->JSON(위도, 경도)
        // JSP -> 지도~~                                 비동기전송(ajax)
        return "restlist"; // restlist.jsp : -- ------요청--> http://localhost:8081/weberp/api/books
                                         //                      <--------응답(JSON)
                                         // 동적인 뷰를 만들어낸다.
    }

    @GetMapping("/restregister")
    public String restregister(){
        return "restregister"; // restregister.jsp
    }
}


