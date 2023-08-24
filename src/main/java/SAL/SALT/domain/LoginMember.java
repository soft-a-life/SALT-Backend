package SAL.SALT.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class LoginMember {

    @NotBlank
    private String userId;
    @NotBlank
    private String userPw;

}
