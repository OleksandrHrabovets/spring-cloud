package com.example.userservice.com.example.userservice.repos;

import com.example.userservice.com.example.userservice.entities.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

}
