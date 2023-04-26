package com.example.DoctorBookingApi.Repositories;

import com.example.DoctorBookingApi.model.City;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    City findByName(String city);

}
