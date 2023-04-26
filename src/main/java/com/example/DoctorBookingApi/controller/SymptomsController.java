package com.example.DoctorBookingApi.controller;

import com.example.DoctorBookingApi.Repositories.SpecialityRepository;
import com.example.DoctorBookingApi.model.Symptoms;
import com.example.DoctorBookingApi.service.SymptomsService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/symptoms")
public class SymptomsController {
    @Autowired
    SymptomsService symptomsService;
    @Autowired
    SpecialityRepository specialityRepository;

    @PostMapping
    public ResponseEntity saveSymptom(@RequestBody String symptoms){
        int id = symptomsService.saveSymptom(symptoms);
        return new ResponseEntity("Symptoms saved with id "+id, HttpStatus.OK);
    }
}
