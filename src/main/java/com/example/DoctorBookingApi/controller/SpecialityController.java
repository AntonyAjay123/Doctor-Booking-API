package com.example.DoctorBookingApi.controller;

import com.example.DoctorBookingApi.model.Speciality;
import com.example.DoctorBookingApi.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/speciality")
public class SpecialityController {
    @Autowired
    SpecialityService specialityService;
    @PostMapping
    public ResponseEntity saveSpeciality(@RequestBody Speciality speciality){
        int id= specialityService.saveSpeciality(speciality);
        return new ResponseEntity("speciality saved with id "+id, HttpStatus.CREATED);
    }
}
