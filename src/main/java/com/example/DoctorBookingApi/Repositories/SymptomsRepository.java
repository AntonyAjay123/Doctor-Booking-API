package com.example.DoctorBookingApi.Repositories;

import com.example.DoctorBookingApi.model.Speciality;
import com.example.DoctorBookingApi.model.Symptoms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomsRepository extends JpaRepository<Symptoms,Integer> {

    Symptoms findByName(String symptom);

}
