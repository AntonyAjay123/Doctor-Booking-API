package com.example.DoctorBookingApi.Repositories;

import com.example.DoctorBookingApi.model.City;
import com.example.DoctorBookingApi.model.Doctor;
import com.example.DoctorBookingApi.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    List<Doctor> findBySpecialityAndCity(Speciality speciality, City city);
}
