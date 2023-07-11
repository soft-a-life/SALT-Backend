package SAL.SALT.controller;

import SAL.SALT.Entity.User;
import SAL.SALT.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * LoginController
 *
 */
@RestController
@RequestMapping("api/authorization")
@CrossOrigin
public class AuthorizationController {
    private final UserRepository userRepository;

    public AuthorizationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        // Query users in DB using data received from login page
        User existingUser = userRepository.getByUserId(user.getUserId());

        // Verify user exists & password matches
        if (existingUser != null && existingUser.getUserPassword().equals(user.getUserPassword())) {
            return ResponseEntity.ok("Login succeed");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User info is incorrect");
        }
    }
}
