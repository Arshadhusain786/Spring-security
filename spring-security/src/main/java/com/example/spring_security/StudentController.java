package com.example.spring_security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController
{
    @GetMapping("/get")
    public String welcomeStudent()
    {
        return "Welcome ! student";
    }
}
