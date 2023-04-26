package com.example.DoctorBookingApi.service;

import com.example.DoctorBookingApi.Repositories.SpecialityRepository;
import com.example.DoctorBookingApi.Repositories.SymptomsRepository;
import com.example.DoctorBookingApi.model.Symptoms;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SymptomsService {
    @Autowired
    SymptomsRepository symptomsRepository;

    @Autowired
    SpecialityRepository specialityRepository;

    public int saveSymptom(String str){
        JSONObject symptoms = new JSONObject(str);
        Symptoms newSymptom = new Symptoms();
        newSymptom.setName(symptoms.getString("name"));
        String speciality = symptoms.getString("speciality");
        newSymptom.setSpeciality(specialityRepository.findByName(speciality));
        symptomsRepository.save(newSymptom);
        return newSymptom.getId();
    }
}
