package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private Long id; // 일련번호, 1 2 3 4 5....
    private String username; // 회원아이디
    private String password; // 회원비번
    private String name; // 이름
    private String email; // 이메일

}
