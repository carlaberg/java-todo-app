package com.todo.todoapp.entities.Auth;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.todo.todoapp.entities.User.User;
import com.todo.todoapp.entities.User.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService adminService;
    private final UserRepository userRepository;

    @PostMapping(path = "/sign-up")
    public UserRecord signupUser(@RequestBody UserSignupDetails userSignupDetails) throws FirebaseAuthException {
        var firebaseUserRecord = adminService.signupUser(userSignupDetails);
        var user = new User();
        user.setFirebaseAuthId(firebaseUserRecord.getUid());
        user.setEmail(firebaseUserRecord.getEmail());
        userRepository.save(user);

        return firebaseUserRecord;
    }
}