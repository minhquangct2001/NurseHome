package com.example.cssk.Controller;

import com.example.cssk.Service.Implement.MenuServiceImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/menu")
public class MenuController {
    @Autowired
    private final MenuServiceImp menuServiceImp;

    @GetMapping()
    public String getAll() {
        return menuServiceImp.findAllMenu();
    }

    @PostMapping()
    public String AddMenu(@RequestBody String jsonString) throws JsonProcessingException {
        return menuServiceImp.createMenu(jsonString);
    }

    @PutMapping("/{id}")
    public String Update(@RequestBody String jsonString, @PathVariable Long id) throws JsonProcessingException {
        return menuServiceImp.updateMenu(id, jsonString);
    }

    @GetMapping("/{id}")
    public String InfoMenu(@PathVariable Long id) {
        return menuServiceImp.getMenuByMenuId(id);
    }

    @DeleteMapping("/{id}")
    public String DeleteMenu(@PathVariable Long id) {
        return menuServiceImp.deleteMenu(id);
    }

    @PutMapping("/disable/{id}")
    public String ToggleDisable(@PathVariable Long id){
        return menuServiceImp.ToggleDisable(id);
    }
}
