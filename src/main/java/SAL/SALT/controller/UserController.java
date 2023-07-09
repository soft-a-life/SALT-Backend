package SAL.SALT.controller;

import SAL.SALT.entity.User;
import SAL.SALT.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody User user) {
        userRepository.save(user);

        return ResponseEntity.ok("Signup is completed.");
    }
}
