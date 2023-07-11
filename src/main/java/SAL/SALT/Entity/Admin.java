package SAL.SALT.Entity;

import javax.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @Column(name = "admin_id", length = 128, nullable = false)
    private String adminId;

    @Column(name = "admin_password", length = 128, nullable = false)
    private String adminPassword;

    @Column(name = "admin_name", length = 16)
    private String adminName;

    @Column(name = "admin_nickname", length = 16)
    private String adminNickname;

    @Column(name = "admin_email", length = 128)
    private String adminEmail;

    public Admin() {
    }

    public Admin(String adminId, String adminPassword, String adminName, String adminNickname, String adminEmail) {
        this.adminId = adminId;
        this.adminPassword = adminPassword;
        this.adminName = adminName;
        this.adminNickname = adminNickname;
        this.adminEmail = adminEmail;
    }
}