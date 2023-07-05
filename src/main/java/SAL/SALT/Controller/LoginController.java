package SAL.SALT.Controller;

import SAL.SALT.Entity.User;
import SAL.SALT.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * LoginController
 *
 */
@RestController
@RequestMapping("/api/auth")
public class LoginController {
    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        // Query users in DB using data received from login page
        User existingUser = userRepository.findByUsername(user.getUsername());

        // Verify user exists & password matches
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok("Login succeed");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User info is incorrect");
        }
    }
}
