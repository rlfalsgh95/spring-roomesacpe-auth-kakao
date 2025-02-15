package nextstep.member;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Member {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String phone;

    public Member(Long id, String username, String password, String name, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }

    public Member(String username, String password, String name, String phone) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }

    public Member() {
    }

    public MemberRequest toDto(){
        return new MemberRequest(this.username, this.password, this.name, this.phone);
    }


    public boolean checkWrongPassword(String password) {
        return !this.password.equals(password);
    }
}
