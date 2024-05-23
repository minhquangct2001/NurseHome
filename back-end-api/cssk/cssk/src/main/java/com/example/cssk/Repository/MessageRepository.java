package com.example.cssk.Repository;

import com.example.cssk.Entity.Message;
import com.example.cssk.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface MessageRepository extends MongoRepository<Message, String> {
}