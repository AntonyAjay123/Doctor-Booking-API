package com.example.DoctorBookingApi.Dto;

import com.example.DoctorBookingApi.model.Doctor;
import com.example.DoctorBookingApi.model.Symptoms;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SpecialityDto {

    String name;

}
