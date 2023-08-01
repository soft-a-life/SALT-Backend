package SAL.SALT.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class LoginMember {

    @NotBlank
    private final String userId;
    @NotBlank
    private final String userPw;

}
