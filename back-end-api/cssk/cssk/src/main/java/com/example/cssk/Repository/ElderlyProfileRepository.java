package com.example.cssk.Repository;

import com.example.cssk.Entity.ElderlyProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ElderlyProfileRepository extends MongoRepository<ElderlyProfile, Long> {
    ElderlyProfile findTopByOrderByIdDesc();
}
