package com.todo.todoapp.config;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(
				User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
		return manager;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.csrf().disable();
		http
			.oauth2ResourceServer(oauth2 -> oauth2
				.jwt(jwt -> jwt
					.jwtAuthenticationConverter(jwtAuthenticationConverter())
				)
			);

		return http.build();
	}

	public JwtAuthenticationConverter jwtAuthenticationConverter() {
		JwtAuthenticationConverter converter = new JwtAuthenticationConverter();

		converter
				.setJwtGrantedAuthoritiesConverter(jwt -> Optional.ofNullable(jwt.getClaimAsStringList("custom_claims"))
						.stream()
						.flatMap(Collection::stream)
						.map(SimpleGrantedAuthority::new)
						.collect(Collectors.toList()));

		return converter;
	}
}