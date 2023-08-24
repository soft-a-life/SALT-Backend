package SAL.SALT.Controller;


import SAL.SALT.Entity.User;
import SAL.SALT.Service.UserService;
import SAL.SALT.domain.LoginMember;
import SAL.SALT.domain.MemberData;
import SAL.SALT.domain.RegisterMember;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final BCryptPasswordEncoder encoder;

    /* SignUp method done with RegisterMember Domain */
    @PostMapping("/signup")
    public String signUp(@RequestBody @Validated RegisterMember registerMember, BindingResult bindingResult) {
        if (userService.findUserId(registerMember.getUserId()).isPresent()) {
            throw new RuntimeException("user already exist.");
        }

        User user = User.builder()
                .userId(registerMember.getUserId())
                .userPw(encoder.encode(registerMember.getUserPw()))
                .userName(registerMember.getUserName())
                .email(encoder.encode(registerMember.getEmail()))
                .userPhone(encoder.encode(registerMember.getUserPhone()))
                .userNickname(registerMember.getUserNickname())
                .userBirth(registerMember.getUserBirth())
                .build();

        userService.save(user);

        return "sign up success";
    }

    @PostMapping("/login")
    public MemberData login(@Validated LoginMember loginMember, BindingResult bindingResult) {
        User user = userService.findUserId(loginMember.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("not exist ID"));

        if (!encoder.matches(loginMember.getUserPw(), user.getUserPw())) {
            throw new IllegalArgumentException("wrong password");
        }

        return new MemberData(user.getUserId(), user.getUserNickname());
    }
}
