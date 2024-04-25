package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    /*   List<Book>=
    [
           {"num": 1, "title":"자바","price": 30000, "author":"나길동","page":400 },
           {"num": 1, "title":"자바","price": 30000, "author":"나길동","page":400 },
           {"num": 1, "title":"자바","price": 30000, "author":"나길동","page":400 }
    ]
    */
    private int num;
    private String title;
    private int price;
    private String author;
    private int page;
    // Lombok API
}
