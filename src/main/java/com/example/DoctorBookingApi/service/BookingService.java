package com.example.DoctorBookingApi.service;

import com.example.DoctorBookingApi.Dto.DoctorDto;
import com.example.DoctorBookingApi.Dto.SpecialityDto;
import com.example.DoctorBookingApi.Repositories.*;
import com.example.DoctorBookingApi.mapper.DoctorMapper;
import com.example.DoctorBookingApi.mapper.SpecialityMapper;
import com.example.DoctorBookingApi.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookingService {
    @Autowired
    SpecialityRepository specialityRepository;
    @Autowired
    SymptomsRepository symptomsRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorMapper doctorMapper;

    @Autowired
    SpecialityMapper specialityMapper;


    public ResponseEntity findDoc(int patientId) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        Patient patient = null;
        if (optionalPatient.isPresent())
            patient = optionalPatient.get();
        else {
            return new ResponseEntity<>("No patient with given id", HttpStatus.NOT_FOUND);
        }
        Symptoms symptom = patient.getSymptoms();
        Speciality speciality = symptom.getSpeciality();
        String city = patient.getCity();
        City presentCity = cityRepository.findByName(city);
        if(presentCity==null)
            return new ResponseEntity<>("We are still waiting to expand to your location",HttpStatus.NOT_FOUND);
        List<Doctor> doctors = doctorRepository.findBySpecialityAndCity(speciality, presentCity);
        if (doctors.isEmpty()) {
            return new ResponseEntity<>("There isn’t any doctor present at your location for your symptom", HttpStatus.NOT_FOUND);
        }
        List<DoctorDto> doctorDtos = new ArrayList<>();
        for (Doctor doctor : doctors) {
            List<Speciality> specialities = specialityRepository.findByDoctors(doctor);
            DoctorDto doctorDto = doctorMapper.modelToDto(doctor);
            Set<SpecialityDto> specialityDtos = specialityMapper.modelToDtos(specialities);
            doctorDto.setSpecialities(specialityDtos);
            doctorDtos.add(doctorDto);
        }
        //return doctorMapper.modelToDtos(doctorRepository.findAll());
        return new ResponseEntity<>(doctorDtos, HttpStatus.FOUND);

    }
}
