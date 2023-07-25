package SAL.SALT.Controller;

import SAL.SALT.Dto.UserDto;
import SAL.SALT.Entity.User;
import SAL.SALT.Service.SignUpService;
import SAL.SALT.domain.RegisterMember;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
//@RequiredArgsConstructor
@RequestMapping("/access")
public class UserApiController {

    private final SignUpService signUpService;

    @Autowired
    public UserApiController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @PostMapping("/signup")
    public String signUpForm(@RequestBody @Validated RegisterMember registerMember, BindingResult bindingResult) {
        return signUpService.signUp(registerMember, bindingResult);
    }

    @PostMapping("/login")
    public void loginForm() {

    }
}
