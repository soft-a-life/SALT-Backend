package SAL.SALT.Entity;

import SAL.SALT.domain.RegisterMember;
import SAL.SALT.Repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Entity
@Builder(builderMethodName = "builder")
@AllArgsConstructor
@Component
public class User {

    @Embedded
    private final UserRepository userRepository;

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

    @Column(name = "uuid")
    private Character uuid;

    @Autowired
    public User(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User () {
        userRepository = null;
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
                .uuid(registerMember.getUuid())
                // Add other necessary fields if needed
                .build();
    }

}
