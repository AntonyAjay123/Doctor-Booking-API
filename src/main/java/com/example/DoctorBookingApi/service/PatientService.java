package com.example.DoctorBookingApi.service;

import com.example.DoctorBookingApi.Repositories.CityRepository;
import com.example.DoctorBookingApi.Repositories.PatientRepository;
import com.example.DoctorBookingApi.Repositories.SymptomsRepository;
import com.example.DoctorBookingApi.model.City;
import com.example.DoctorBookingApi.model.Doctor;
import com.example.DoctorBookingApi.model.Patient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    CityRepository cityRepository;

    @Autowired
    SymptomsRepository symptomsRepository;
    public int savePatient(String pat){
        JSONObject patient = new JSONObject(pat);
        Patient newPatient = new Patient();
        newPatient.setName(patient.getString("name"));
        String city=patient.getString("city");
        newPatient.setCity(city);
        newPatient.setSymptoms(symptomsRepository.findByName(patient.getString("symptoms")));
        patientRepository.save(newPatient);
        return newPatient.getId();
    }
}
