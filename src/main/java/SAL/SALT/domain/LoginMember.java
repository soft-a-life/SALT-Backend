package SAL.SALT.domain;

import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotBlank;


@Data
@Getter
public class LoginMember {

    @NotBlank
    private final String userId;
    @NotBlank
    private final String userPw;

}
