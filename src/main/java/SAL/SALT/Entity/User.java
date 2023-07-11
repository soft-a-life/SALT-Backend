package SAL.SALT.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import org.jetbrains.annotations.Contract;

/**
 * User entity
 */

@Getter
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_id", length = 128, nullable = false)
    private Long userId;

    @Column(name = "user_name", length = 16)
    private String userName;

    @Column(name = "user_cellphone", length = 128)
    private String userCellphone;

    @Column(name = "user_email", length = 128)
    private String userEmail;

    @Column(name = "user_password", length = 128, nullable = false)
    private String userPassword;

    @Column(name = "nickname", length = 16, columnDefinition = "VARCHAR(16) DEFAULT 'user'")
    private String nickname;

    @Column(name = "register_date")
    private LocalDateTime registerDate;

    @Column(name = "user_update_date")
    private LocalDateTime userUpdateDate;

    public User() {
    }

    @Contract(pure = true)
    public User(Long userId, String userName, String userCellphone, String userEmail,
                String nickname, LocalDateTime registerDate, LocalDateTime userUpdateDate) {
        this.userId = userId;
        this.userName = userName;
        this.userCellphone = userCellphone;
        this.userEmail = userEmail;
        this.nickname = nickname;
        this.registerDate = registerDate;
        this.userUpdateDate = userUpdateDate;
    }

}

