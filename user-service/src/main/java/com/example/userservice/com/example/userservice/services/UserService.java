package com.example.userservice.com.example.userservice.services;

import com.example.userservice.com.example.userservice.entities.User;
import com.example.userservice.com.example.userservice.entities.value_objects.Department;
import com.example.userservice.com.example.userservice.entities.value_objects.ResponseTemplateVO;
import com.example.userservice.com.example.userservice.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

  private final UserRepository repository;
  private final RestTemplate restTemplate;

  public User save(User user) {
    return this.repository.save(user);
  }

  public User getById(ObjectId id) {
    return this.repository.findById(id).orElse(null);
  }

  public ResponseTemplateVO getUserWithDepartment(String id) {
    User user = this.getById(new ObjectId(id));

    Department department = restTemplate.getForObject(
        "http://department-service/departments/" + user.getDepartmentId(), Department.class);

    return new ResponseTemplateVO(user, department);
  }
}
