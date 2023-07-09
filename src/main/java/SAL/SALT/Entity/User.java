package SAL.SALT.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * User entity
 */

@Getter  @Setter  @Entity  @Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_email", nullable = false)
    private String userEmail;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Column(name = "user_registered_day")
    private LocalDateTime userRegisteredDay;

    public User() {
        // 기본 생성자
    }

    public User(String userName, String userEmail, String userPassword) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userRegisteredDay = LocalDateTime.now();
    }

    public Long getUserId() {
        return userId;
    }

    public String getPassword() {
        return userPassword;
    }

    // 기타 로직 및 관계 설정 추가
}

