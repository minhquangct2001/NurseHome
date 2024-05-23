package com.example.cssk.Controller;

import com.example.cssk.Service.Implement.MedicalExaminationImp;
import com.example.cssk.Service.Implement.ServiceArisingImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/examination")
@CrossOrigin(origins = "http://localhost:3001/")
@AllArgsConstructor
public class MedicalExaminationController {
    @Autowired
    private final MedicalExaminationImp medicalExaminationImp;

    @GetMapping()
    public String getAllMedicalExamination()  {
        return medicalExaminationImp.findAllMedicalExamination();
    }

    @GetMapping("/{medicalExaminationId}")
    public String getById(@PathVariable long medicalExaminationId ){
        return String.valueOf(medicalExaminationImp.getMedicalExaminationByMedicalExaminationId(medicalExaminationId));
    }
    @PostMapping()
    public String creatServiceArising(@RequestBody String jsonString) throws JsonProcessingException {
        return medicalExaminationImp.createMedicalExamination(jsonString);
    }
    @PutMapping("/{medicalExaminationId}")
    public String updateServiceArisingById(@PathVariable Long medicalExaminationId, @RequestBody String jsonString) throws JsonProcessingException {
        return medicalExaminationImp.updateMedicalExaminationById(medicalExaminationId, jsonString );
    }
    @DeleteMapping("/{medicalExaminationId}")
    public String deleteServiceArising(@PathVariable Long medicalExaminationId) throws JsonProcessingException {
        return medicalExaminationImp.deleteMedicalExamination(medicalExaminationId);
    }

    @GetMapping("/elderly/{elderlyId}")
    public String getByElderlyId(@PathVariable Long elderlyId){
        return medicalExaminationImp.findEXByElderlyId(elderlyId);
    }
}
