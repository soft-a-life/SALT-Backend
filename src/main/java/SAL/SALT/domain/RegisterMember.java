package SAL.SALT.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.sql.Date;


@Data
public class RegisterMember {

    @NotBlank
    private String userId;
    @NotBlank
    private String userPw;
    @NotBlank
    private String userName;
    @Email
    private String email;
    @NotBlank
    private String userPhone;

    private String userNickname;

    private Date userBirth;
}
