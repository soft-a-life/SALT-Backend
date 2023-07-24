package SAL.SALT.Controller;

import SAL.SALT.Dto.UserDto;
import SAL.SALT.Entity.User;
import SAL.SALT.Service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public User signUpForm(@RequestBody UserDto userDto) {
        return signUpService.signUp(userDto);
    }

    @PostMapping("/login")
    public void loginForm() {

    }
}
