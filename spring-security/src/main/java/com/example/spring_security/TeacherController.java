package com.example.spring_security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher ")

public class TeacherController
{
    @GetMapping("/get")
    public String welcomeTeacher()
    {
        return "Welcome ! teacher";
    }

}
