package com.todo.todoapp.entities.User;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    private String id;
    private String firebaseAuthId;
    private String email;

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirebaseAuthId() {
        return firebaseAuthId;
    }

    public void setFirebaseAuthId(String firebaseAuthId) {
        this.firebaseAuthId = firebaseAuthId;
    }
}
