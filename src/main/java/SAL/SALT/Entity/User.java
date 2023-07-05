package SAL.SALT.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String nickname;
    @Column(nullable = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Date registeredDay;

    public User(String name, String nickname, String email, String password, Date registeredDay) {
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.registeredDay = registeredDay;
    }

    public User() {

    }

    public String getUsername() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }
}
