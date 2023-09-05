package SAL.SALT.Controller;

import SAL.SALT.Service.LoginService;
import SAL.SALT.Service.SignUpService;
import SAL.SALT.domain.LoginMember;
import SAL.SALT.domain.RegisterMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/access")
public class UserApiController {

    private final SignUpService signUpService;

    private final LoginService loginService;

    @Autowired
    public UserApiController(SignUpService signUpService, LoginService loginService) {
        this.signUpService = signUpService;
        this.loginService = loginService;
    }

    @PostMapping("/signup")
    public String signUpForm(@RequestBody @Validated RegisterMember registerMember, BindingResult bindingResult) {
        return signUpService.signUp(registerMember, bindingResult);
    }

    @PostMapping("/login")
    public String loginForm(@RequestBody @Validated LoginMember loginMember, BindingResult bindingResult) {
        return loginService.login(loginMember, bindingResult); // LoginService의 login 메서드 호출
    }
}
