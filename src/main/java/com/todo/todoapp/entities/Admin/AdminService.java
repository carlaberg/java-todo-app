package com.todo.todoapp.entities.Admin;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.todo.todoapp.enums.Role;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final FirebaseAuth firebaseAuth;

    public void setUserClaims(String uid, List<Role> requestedPermissions) throws FirebaseAuthException {
        List<String> permissions = requestedPermissions
                .stream()
                .map(Enum::toString)
                .collect(Collectors.toList());

        Map<String, Object> claims = Map.of("custom_claims", permissions);

        firebaseAuth.setCustomUserClaims(uid, claims);
    }
}