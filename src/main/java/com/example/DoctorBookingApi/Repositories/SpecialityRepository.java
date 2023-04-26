package com.example.DoctorBookingApi.Repositories;

import com.example.DoctorBookingApi.model.Doctor;
import com.example.DoctorBookingApi.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality,Integer> {

    Speciality findByName(String name);

    List<Speciality> findByDoctors(Doctor doctor);

}
