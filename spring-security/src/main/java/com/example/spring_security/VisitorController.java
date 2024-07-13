package com.example.spring_security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visitor")

public class VisitorController
{
  @GetMapping("/get")
    public String getVisitor()
    {
      return "welcome Visitor";
    }
}
