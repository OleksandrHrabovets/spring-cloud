package com.example.departmentsservice.controllers;

import com.example.departmentsservice.entities.Department;
import com.example.departmentsservice.services.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

  @Autowired
  private DepartmentService departmentService;


  @PostMapping
  public Department save(@RequestBody Department department) {
    return departmentService.save(department);
  }

  @GetMapping("/{id}")
  public Department getById(@PathVariable long id) {
    return departmentService.getById(id);
  }

}
