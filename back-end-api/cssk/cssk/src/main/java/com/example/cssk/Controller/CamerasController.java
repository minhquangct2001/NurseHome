package com.example.cssk.Controller;

import com.example.cssk.Service.IService.CamerasService;
import com.example.cssk.Service.Implement.CamerasServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cameras")
@CrossOrigin(origins = "http://localhost:3001/")
@AllArgsConstructor
public class CamerasController {

    private final CamerasServiceImp camerasServiceImp;


    @GetMapping()
    public String getAllCameras() {
        return camerasServiceImp.getAllCameras();
    }

    @GetMapping("/{camerasId}")
    public String getCamerasById(@PathVariable String camerasId) {
        return camerasServiceImp.getCameraById(camerasId);
    }

    @GetMapping("/elderly")
    public String getCamerasByElderly() {
        return camerasServiceImp.getCamerasForElderly();
    }

    @PostMapping()
    public String createCameras(@RequestBody String jsonString) {
        return camerasServiceImp.createCameras(jsonString).toString();
    }

    @PutMapping("/{camerasId}")
    public String updateCameras(@RequestBody String jsonString, @PathVariable String camerasId) {
        return camerasServiceImp.updateCameras(jsonString, camerasId).toString();
    }

    @DeleteMapping("/{camerasId}")
    public String deleteCameras( @PathVariable String camerasId) {
        return camerasServiceImp.deleteCameras( camerasId).toString();
    }
}
