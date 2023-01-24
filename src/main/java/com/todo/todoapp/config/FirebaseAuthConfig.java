package com.todo.todoapp.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Configuration
public class FirebaseAuthConfig {

    @Value("classpath:service-account.json")
    Resource serviceAccount;

    @Bean
    FirebaseAuth firebaseAuth() throws IOException {
        FirebaseApp firebaseApp;

        if (FirebaseApp.getApps().isEmpty()) {
            var options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount.getInputStream()))
                    .build();

                    firebaseApp = FirebaseApp.initializeApp(options);
        } else {
            firebaseApp = FirebaseApp.getInstance();
        }
        
        
        return FirebaseAuth.getInstance(firebaseApp);
    }
}