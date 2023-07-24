package SAL.SALT.domain;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.sql.Date;


@Data
public class RegisterMember {

    @NotBlank
    private final String userId;
    @NotBlank
    private final String userPw;
    @NotBlank
    private final String userName;
    @NotBlank
    @Email
    private final String email;
    @NotBlank
    private final String userPhone;

    private final String userNickname;

    private final Date userBirth;
}
