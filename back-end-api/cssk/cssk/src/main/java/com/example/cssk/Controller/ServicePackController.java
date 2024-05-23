package com.example.cssk.Controller;

import com.example.cssk.Service.Implement.ServiceServicePackServiceImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pack")

public class ServicePackController {
    private final ServiceServicePackServiceImp servicePackServiceImp;

    public ServicePackController(ServiceServicePackServiceImp servicePackServiceImp) {
        this.servicePackServiceImp = servicePackServiceImp;
    }

    @GetMapping()
    public String allServicePack(){
        return servicePackServiceImp.allServicePack();
    }

    @GetMapping("/{packId}")
    public String getPackByPackId(@PathVariable long packId){
        return servicePackServiceImp.getPackByPackId(packId);
    }

    @PostMapping()
    public String createServicePack(@RequestBody String jsonString){
        return servicePackServiceImp.createServicePack(jsonString).toString();
    }

    @PutMapping()
    public String updateServicePack(@RequestBody String jsonString){
        return servicePackServiceImp.updateServicePack(jsonString).toString();
    }

    @DeleteMapping()
    public String deleteServicePack(@RequestBody String jsonString){
        return servicePackServiceImp.deleteServicePack(jsonString).toString();
    }
}
