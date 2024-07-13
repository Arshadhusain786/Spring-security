package com.example.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder getPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() // inbuilt class
    {
        UserDetails student = User.withUsername("Student1")
                .password(getPasswordEncoder().encode("student"))
                .roles("STUDENT")
                .build();

        UserDetails teacher = User.withUsername("teacher1")
                                  .password(getPasswordEncoder().encode("teacher") )
                                  .roles("TEACHER")
                                  .build();
        return new InMemoryUserDetailsManager(student,teacher);

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.csrf().disable() // Disable CSRF protection
                .authorizeHttpRequests() // Configure authorization requests
                .requestMatchers("/visitor/**")
                .permitAll() // Allow all requests to /visitor/** without authentication
                .requestMatchers("/student/**")
                .hasRole("STUDENT")
                .requestMatchers("/teacher/**")
                .hasRole("TEACHER")
                .anyRequest()
                .authenticated() // Require authentication for any other requests
                .and()
                .formLogin();

        return http.build(); // Build the SecurityFilterChain
    }
}

