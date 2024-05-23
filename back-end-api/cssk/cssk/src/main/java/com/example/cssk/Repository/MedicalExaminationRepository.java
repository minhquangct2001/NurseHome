package com.example.cssk.Repository;

import com.example.cssk.Entity.MedicalExamination;
import com.example.cssk.Entity.ServicePack;
import com.example.cssk.Entity.ServicesArising;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MedicalExaminationRepository extends MongoRepository<MedicalExamination, Long> {
    MedicalExamination findTopByOrderByMedicalExaminationIdDesc();

    MedicalExamination findServicePackByMedicalExaminationId(Long medicalExaminationId);

    MedicalExamination deleteByMedicalExaminationId(Long medicalExaminationId);

    List<MedicalExamination> findAllByRemoveFalse();

    List<MedicalExamination> findAllByElderlyIdAndRemoveFalse(Long elderlyId);

}
