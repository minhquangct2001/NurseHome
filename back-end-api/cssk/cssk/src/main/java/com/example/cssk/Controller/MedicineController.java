package com.example.cssk.Controller;

import com.example.cssk.Service.Implement.ElderlyServiceImp;
import com.example.cssk.Service.Implement.MedicineServiceImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medicine")
@CrossOrigin(origins = "http://localhost:3001/")
@AllArgsConstructor
public class MedicineController {
    @Autowired
    private final MedicineServiceImp medicineServiceImp;

    @GetMapping()
    public String getAllMedicine()  {
        return medicineServiceImp.findAllMedicine();
    }
    @PostMapping()
    public String creatMedicine(@RequestBody String jsonString) throws JsonProcessingException {
        return medicineServiceImp.createMedicine(jsonString);
    }
    @GetMapping("/{medicineId}")
    public String getMedicineByMedicineId(@PathVariable Long medicineId) throws JsonProcessingException {
        return medicineServiceImp.getMedicineByMedicineId(medicineId);
    }
    @PutMapping("/{medicineId}")
    public String updateMedicineById(@PathVariable Long medicineId, @RequestBody String jsonString) throws JsonProcessingException {
        return medicineServiceImp.updateMedicineById(medicineId, jsonString );
    }
    @DeleteMapping("/{medicineId}")
    public String deleteMedicine(@PathVariable Long medicineId) throws JsonProcessingException {
        return medicineServiceImp.deleteMedicine(medicineId);
    }
}
