package SAL.SALT.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_email", nullable = false)
    private String userEmail;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Column(name = "user_registered_day")
    private LocalDateTime userRegisteredDay;

    // 생성자, getter, setter 등 필요한 메서드 추가

    // 기타 로직 및 관계 설정 추가
}

