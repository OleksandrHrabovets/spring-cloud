package com.example.eurekaservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

  @Value("${eureka.instance.instance-id}")
  private String id;

  @GetMapping("/test")
  public String get() {
    return "Test response from " + id;
  }
}
