package com.example.userservice.com.example.userservice.entities.value_objects;

import com.example.userservice.com.example.userservice.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseTemplateVO {

  private User user;
  private Department department;
}
