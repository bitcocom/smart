package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int num;
    private String title;
    private int price;
    private String author;
    private int page;
    // Lombok API
}
