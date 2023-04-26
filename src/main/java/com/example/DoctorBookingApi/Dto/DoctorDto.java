package com.example.DoctorBookingApi.Dto;

import com.example.DoctorBookingApi.model.City;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DoctorDto {
    Integer id;

    String name;

    CityDto city;

    String email;

    String phoneNo;

    Set<SpecialityDto> specialities = new HashSet<>();
}
