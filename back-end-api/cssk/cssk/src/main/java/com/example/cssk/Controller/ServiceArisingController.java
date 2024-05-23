package com.example.cssk.Controller;

import com.example.cssk.Service.Implement.ServiceArisingImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/arising")
@AllArgsConstructor
public class ServiceArisingController {
    @Autowired
    private final ServiceArisingImp serviceArisingImp;

    @GetMapping()
    public String getAllServiceArising()  {
        return serviceArisingImp.findAllServiceArising();
    }

    @GetMapping("/{serviceArisingId}")
    public String getById(@PathVariable long serviceArisingId ){
        return String.valueOf(serviceArisingImp.getServiceArisingByServiceArisingId(serviceArisingId));
    }
    @PostMapping()
    public String creatServiceArising(@RequestBody String jsonString) throws JsonProcessingException {
        return serviceArisingImp.createServiceArising(jsonString);
    }
    @PutMapping("/{serviceArisingId}")
    public String updateServiceArisingById(@PathVariable Long serviceArisingId, @RequestBody String jsonString) throws JsonProcessingException {
        return serviceArisingImp.updateServiceArisingById(serviceArisingId, jsonString );
    }
    @DeleteMapping("/{serviceArisingId}")
    public String deleteServiceArising(@PathVariable Long serviceArisingId) throws JsonProcessingException {
        return serviceArisingImp.deleteServiceArising(serviceArisingId);
    }

}
