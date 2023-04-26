package com.example.DoctorBookingApi.service;

import com.example.DoctorBookingApi.Repositories.SpecialityRepository;
import com.example.DoctorBookingApi.model.Speciality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialityService {
    @Autowired
    SpecialityRepository specialityRepository;


    public int saveSpeciality(Speciality speciality){

        specialityRepository.save(speciality);
        int id = speciality.getId();
        return id;
    }
}
