package com.example.cssk.Repository;

import com.example.cssk.Entity.AdministrativePaperwork;
import com.example.cssk.Entity.Menu;
import com.example.cssk.Entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MenuRepository extends MongoRepository<Menu,Long> {
    Menu findTopByOrderByMenuIdDesc();
    boolean existsByMenuId(Long MenuId);
    Menu findByMenuId(Long MenuId);
    List<Menu> findAllByDisableFalse();

    List<Menu> findAllByOrderByMenuIdDesc();
}
