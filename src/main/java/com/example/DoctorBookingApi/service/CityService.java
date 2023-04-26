package com.example.DoctorBookingApi.service;

import com.example.DoctorBookingApi.Repositories.CityRepository;
import com.example.DoctorBookingApi.model.City;
import com.example.DoctorBookingApi.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Set;

@Service
public class CityService {
    @Autowired
    CityRepository cityRepository;

    public int saveCity(City city){
        cityRepository.save(city);
        return city.getId();
    }

    public int updateCity(City city, Set<Doctor> docs, Doctor doc){
        docs.add(doc);
        city.setDoctors(docs);
        cityRepository.save(city);
        return 1;
    }

    public List<City> getCities(){
        return  cityRepository.findAll();
    }
}
