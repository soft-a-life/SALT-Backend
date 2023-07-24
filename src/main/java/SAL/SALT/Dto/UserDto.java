package SAL.SALT.Dto;

import SAL.SALT.Entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class UserDto {
    private String userId;
    @JsonIgnore
    private String userPw;
    private String userNickname;
    private String email;

    /* DTO -> Entity */
    public User toEntity() {
        User user = User.builder()
                .userId(userId)
                .userPw(userPw)
                .userNickname(userNickname)
                .email(email)
                .build();
        return user;
    }
}
