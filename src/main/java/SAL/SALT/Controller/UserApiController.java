package SAL.SALT.Controller;

import SAL.SALT.Dto.UserDto;
import SAL.SALT.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/access")
public class UserApiController {

    private final UserService userService;

    @PostMapping("/signup")
    public void signUpForm() {

    }

    @PostMapping("/login")
    public void loginForm() {

    }
}
