package SAL.SALT.Entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
@Builder(builderMethodName = "builder")
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_num")
    private Integer userNum;

    @Column(length = 16, name = "user_id", unique = true, nullable = false)
    private String userId;

    @Column(length = 256, name = "user_pw", nullable = false)
    private String userPw;

    @Column(length = 32, name = "user_name")
    private String userName;

    @Column(length = 16, name = "user_nickname", unique = true)
    private String userNickname;

    @Column(name = "user_birth")
    private Date userBirth;

    @Column(length = 256, name = "email", unique = true)
    private String email;

    @Column(length = 256, name = "user_phone", unique = true)
    private String userPhone;

    @Column(name = "register_date")
    private Date registerDate;

    @Column(name = "update_date")
    private Timestamp updateDate;

    @Column(name = "is_withdrawal")
    private String isWithdrawal;

    @Column(name = "is_admin")
    private String isAdmin;

}
