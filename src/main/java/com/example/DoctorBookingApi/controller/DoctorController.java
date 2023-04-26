package com.example.DoctorBookingApi.controller;

import com.example.DoctorBookingApi.Dto.DoctorDto;
import com.example.DoctorBookingApi.mapper.DoctorMapper;
import com.example.DoctorBookingApi.model.Doctor;
import com.example.DoctorBookingApi.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @Autowired
    DoctorMapper doctorMapper;

    @GetMapping
    public ResponseEntity<List<DoctorDto>> getDoctors(){
        return new ResponseEntity<>(doctorService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveDoc(@RequestBody String doctor){
        int id = doctorService.saveDoctor(doctor);
        return new ResponseEntity("doc saved with id "+id,HttpStatus.OK);
    }

    @GetMapping("/speciality")
    public ResponseEntity getSpecialityDocs(@RequestParam int specId,
                                            @RequestParam int cityId){
        return new ResponseEntity(doctorService.getSpecDocs(specId,cityId),HttpStatus.OK);
    }
}
