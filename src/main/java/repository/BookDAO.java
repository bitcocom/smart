package repository;

import entity.Book;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

// JDBC -> MyBatis(mybatis.org)-> Spring Mybatis-> | Hibernate(ORM) -> JPA(?)
// JDBC -> Java 소스코드 + SQL :  유지보수어렵다, 생산성이 떨어진다(?).
public class BookDAO { // new BookDAO()
    private static SqlSessionFactory sqlSessionFactory;
    // API ? : SqlSessionFactoryBuilder -> config.xml -> Connection Pool(Connection(SqlSession) : 5~7)
    // 초기화 블럭
    static{
        try{
            String resource = "mybatis-config/config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
             sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    // CRUD Method ~
    public List<Book> bookList(){
        // SqlSession을 꺼내오기
        SqlSession session =sqlSessionFactory.openSession();
        // select * from book : SQL 전송(BookMapper.xml)
        List<Book> list=session.selectList("bookList"); // JDBC
       session.close(); // 반납
        return list;
    }

    public int bookRegister(Book book){
        SqlSession session =sqlSessionFactory.openSession();
        int cnt=session.insert("bookRegister", book);
        session.commit(); // 완료(I, D, U)
        session.close();
        return cnt;
    }
}
