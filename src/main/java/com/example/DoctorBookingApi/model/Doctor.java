package com.example.DoctorBookingApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_doctor")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;


    @ManyToOne
    @JoinColumn(name = "City")
    City city;

    String email;

    String phoneNo;

    @ManyToMany
    @JoinTable(name = "doctor_speciality",
    joinColumns =@JoinColumn(name="doctor_id"),
    inverseJoinColumns =@JoinColumn(name="speciality_id"))
    Set<Speciality> speciality = new HashSet<>();

}
