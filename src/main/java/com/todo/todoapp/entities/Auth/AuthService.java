package com.todo.todoapp.entities.Auth;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final FirebaseAuth firebaseAuth;

    public UserRecord signupUser(UserSignupDetails userSignupDetails) throws FirebaseAuthException {
        CreateRequest request = new CreateRequest()
            .setEmail(userSignupDetails.getEmail())
            .setPassword(userSignupDetails.getPassword());

        UserRecord userRecord = firebaseAuth.createUser(request);
        
        return userRecord;
    }
}