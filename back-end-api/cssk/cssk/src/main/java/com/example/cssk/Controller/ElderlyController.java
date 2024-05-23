package com.example.cssk.Controller;

import com.example.cssk.Service.Implement.ElderlyServiceImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/elderly")
@CrossOrigin(origins = "http://localhost:3001/")
@AllArgsConstructor
public class ElderlyController {
    @Autowired
    private final ElderlyServiceImp elderlyServiceImp;

    @GetMapping()
    public String getAllElderly() throws JsonProcessingException {
        return elderlyServiceImp.findAllElderly().toString();
    }

    @PostMapping()
    public String createUser(@RequestBody String jsonString) throws JsonProcessingException {
        return elderlyServiceImp.createElderly(jsonString);
    }

    @GetMapping("/{elderlyId}")
    public String getElderlyByElderlyId(@PathVariable Long elderlyId) throws JsonProcessingException {
        return elderlyServiceImp.getElderlyByElderlyId(elderlyId);
    }

    @PutMapping("/{elderlyId}")
    public String updateElderly(@PathVariable Long elderlyId, @RequestBody String jsonString) throws JsonProcessingException {
        return elderlyServiceImp.updateElderly(elderlyId, jsonString).toString();
    }

    @PutMapping("accept/{elderlyId}")
    public String updateStatus(@PathVariable Long elderlyId, @RequestBody String jsonString) throws JsonProcessingException {
        return elderlyServiceImp.updateStatus(elderlyId, jsonString).toString();
    }

    @PutMapping("sr/{elderlyId}")
    public String updateSR(@PathVariable Long elderlyId, @RequestBody String jsonString) throws JsonProcessingException {
        return elderlyServiceImp.updateSR(elderlyId, jsonString).toString();
    }

    @DeleteMapping("/{elderlyId}")
    public String deleteElderly(@PathVariable Long elderlyId) throws JsonProcessingException {
        return elderlyServiceImp.deleteElderly(elderlyId).toString();
    }

    @GetMapping("/token")
    public JSONObject info() {
        return elderlyServiceImp.getElderlyByToken();
    }
}
