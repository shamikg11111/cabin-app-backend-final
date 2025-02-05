package controller;

import model.User;
import service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        return userService.findByUsername(loginRequest.getUsername())
                .map(user -> user.getPassword().equals(loginRequest.getPassword()) 
                    ? ResponseEntity.ok("Login successful!") 
                    : ResponseEntity.status(401).body("Invalid password"))
                .orElse(ResponseEntity.status(404).body("User not found"));
    }
}
