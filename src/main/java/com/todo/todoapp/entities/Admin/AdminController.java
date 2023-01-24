package com.todo.todoapp.entities.Admin;

import com.google.firebase.auth.FirebaseAuthException;
import com.todo.todoapp.enums.Role;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @Secured("ROLE_ANONYMOUS")
    @PostMapping(path = "/user-claims/{uid}")
    public void setUserClaims(
            @PathVariable String uid,
            @RequestBody List<Role> requestedClaims
    ) throws FirebaseAuthException {
        adminService.setUserClaims(uid, requestedClaims);
    }

}