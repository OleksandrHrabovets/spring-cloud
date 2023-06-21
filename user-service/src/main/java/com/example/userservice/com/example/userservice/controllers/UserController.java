package com.example.userservice.com.example.userservice.controllers;

import com.example.userservice.com.example.userservice.entities.User;
import com.example.userservice.com.example.userservice.entities.value_objects.ResponseTemplateVO;
import com.example.userservice.com.example.userservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping
  public User save(@RequestBody User user) {
    return userService.save(user);
  }

  @GetMapping
  public ResponseTemplateVO getUser(
      @RequestHeader(value = "id") String userId,
      @RequestHeader(value = "role") String role) {
    return userService.getUserWithDepartment(userId);
  }

  @GetMapping(value = "/secure")
  public String getSecure() {
    return "Secure endpoint available";
  }
}
