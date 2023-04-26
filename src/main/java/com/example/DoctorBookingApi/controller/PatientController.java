package com.example.DoctorBookingApi.controller;

import com.example.DoctorBookingApi.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    @PostMapping
    public ResponseEntity savePatient(@RequestBody String patient){
        int id=patientService.savePatient(patient);
        return new ResponseEntity("Patient saved with id "+id, HttpStatus.OK);
    }
}
