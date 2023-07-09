package SAL.SALT.controller;

import SAL.SALT.entity.User;
import SAL.SALT.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * LoginController
 *
 */
@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthorizationController {
    private final UserRepository userRepository;

    public AuthorizationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        // Query users in DB using data received from login page
        User existingUser = userRepository.findByUserId(user.getUserId());

        // Verify user exists & password matches
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok("Login succeed");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User info is incorrect");
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) {
        try {
            // Save data received from signup page to DB
            userRepository.save(user);
            return ResponseEntity.ok("Signup succeed");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Signup failed.");
        }
    }
}
