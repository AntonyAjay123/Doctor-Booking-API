package com.example.DoctorBookingApi.service;

import com.example.DoctorBookingApi.Dto.CityDto;
import com.example.DoctorBookingApi.Dto.DoctorDto;
import com.example.DoctorBookingApi.Dto.SpecialityDto;
import com.example.DoctorBookingApi.Repositories.CityRepository;
import com.example.DoctorBookingApi.Repositories.DoctorRepository;
import com.example.DoctorBookingApi.Repositories.SpecialityRepository;
import com.example.DoctorBookingApi.mapper.CityMapper;
import com.example.DoctorBookingApi.mapper.DoctorMapper;
import com.example.DoctorBookingApi.mapper.DoctorMapperImpl;
import com.example.DoctorBookingApi.mapper.SpecialityMapper;
import com.example.DoctorBookingApi.model.City;
import com.example.DoctorBookingApi.model.Doctor;
import com.example.DoctorBookingApi.model.Speciality;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    SpecialityRepository specialityRepository;

    @Autowired
    CityMapper cityMapper;

    @Autowired
    DoctorMapper doctorMapper;

    @Autowired
    SpecialityMapper specialityMapper;


    public List<DoctorDto> findAll(){
        List<Doctor> doctors = doctorRepository.findAll();
        List<DoctorDto> doctorDtos = new ArrayList<>();
        for (Doctor doctor:doctors){
            List<Speciality> specialities = specialityRepository.findByDoctors(doctor);
            DoctorDto doctorDto = doctorMapper.modelToDto(doctor);
            Set<SpecialityDto> specialityDtos = specialityMapper.modelToDtos(specialities);
            doctorDto.setSpecialities(specialityDtos);
            doctorDtos.add(doctorDto);
        }
       //return doctorMapper.modelToDtos(doctorRepository.findAll());
        return doctorDtos;
    }

    public int saveDoctor(String str){
        JSONObject doctor = new JSONObject(str);
        Doctor newDoctor = new Doctor();
        newDoctor.setName(doctor.getString("name"));
        newDoctor.setEmail(doctor.getString("email"));
        City city=cityRepository.findByName(doctor.getString("city"));
        newDoctor.setCity(city);
        newDoctor.setPhoneNo(doctor.getString("phoneNo"));

        doctorRepository.save(newDoctor);
        String specialities= doctor.getString("speciality");
        String[] specs= specialities.split(",",0);
        Set<Doctor> docs = city.getDoctors();
        CityDto cityDto = cityMapper.modelToDto(city);
        DoctorDto doctorDto = doctorMapper.modelToDto(newDoctor);
         doctorDto.setCity(cityDto);
        for(String s:specs) {
            Speciality speciality=specialityRepository.findByName(s);
            addSpecToDoc(newDoctor.getId(), speciality.getId());
        }
//        docs.add(doctorMapper.dtoToModel(doctorDto));
//        city.setDoctors(docs);
//       cityRepository.save(city);
        return newDoctor.getId();
    }

    public void addSpecToDoc(Integer docId,Integer specId){
        Doctor doctor = doctorRepository.findById(docId).get();
        Speciality speciality = specialityRepository.findById(specId).get();
        Set<Speciality> specialitySet=doctor.getSpeciality();
        specialitySet.add(speciality);
        doctor.setSpeciality(specialitySet);
        doctorRepository.save(doctor);
    }

    public List<Doctor> getSpecDocs(int specId,int cityId){
        Speciality speciality = specialityRepository.findById(specId).get();
        City city = cityRepository.findById(cityId).get();
        return doctorRepository.findBySpecialityAndCity(speciality,city);
    }


}
