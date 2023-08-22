package SAL.SALT.Entity;

import SAL.SALT.domain.RegisterMember;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Entity
@Builder(builderMethodName = "builder")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_num")
    private Long userNum;

    @Column(name = "user_id", unique = true, nullable = false)
    private String userId;

    @Column(name = "user_pw", nullable = false)
    private String userPw;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_nickname", unique = true)
    private String userNickname;

    @Column(name = "user_birth")
    private Date userBirth;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "user_phone", unique = true)
    private String userPhone;

    @CreatedDate
    @Column(name = "register_date", updatable = false)
    private LocalDateTime registerDate;

    @LastModifiedDate
    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "is_withdrawal")
    private String isWithdrawal;

    @Column(name = "is_admin")
    private ManagerAuthority isAdmin;

    protected User() {
    }

    public static User from(RegisterMember registerMember) {
        return User.builder()
                .userId(registerMember.getUserId())
                .userPw(registerMember.getUserPw())
                .userName(registerMember.getUserName())
                .email(registerMember.getEmail())
                .userPhone(registerMember.getUserPhone())
                .userNickname(registerMember.getUserNickname())
                .userBirth(registerMember.getUserBirth())
                // 필요하다면 여기에 다른 필드들도 추가
                .build();
    }

}
