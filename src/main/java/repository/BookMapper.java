package repository;

import entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// JDBC -> MyBatis(mybatis.org)-> Spring Mybatis-> | Hibernate(ORM) -> JPA(?)
// JDBC -> Java 소스코드 + SQL :  유지보수어렵다, 생산성이 떨어진다(?).

public interface BookMapper { // BookDAO dao=new BookDAO(); X
    // CRUD Method ~
    public List<Book> bookList(); // 추상메서드
    public int bookRegister(Book book); // 추상메서드
    public void bookDelete(int num);   // #{num}
}
/*
                                     제공해준다?
   public class SqlSessionFactoryBean implements BookMapper{
      public List<Book> bookList(){
          코드자 자동으로 만들어진다~~~
          String SQL="  select * from book order by price desc";
          SqlSession session=openSession();
      }
      public int bookRegister(Book book){
          코드자 자동으로 만들어진다~~~
      }
   }
  BookDAO dao=new SqlSessionFactoryBean();

 */