package com.example.DoctorBookingApi.controller;

import com.example.DoctorBookingApi.Dto.CityDto;
import com.example.DoctorBookingApi.mapper.CityMapper;
import com.example.DoctorBookingApi.model.City;
import com.example.DoctorBookingApi.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    CityService cityService;
    @Autowired
    CityMapper cityMapper;
    @PostMapping
    public ResponseEntity saveCity(@RequestBody City city){
        int id= cityService.saveCity(city);
        return new ResponseEntity("City saved with id "+id, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<CityDto>> getCities(){
        return new ResponseEntity<>(cityMapper.modelToDtos(cityService.getCities()),HttpStatus.OK);
    }
}
