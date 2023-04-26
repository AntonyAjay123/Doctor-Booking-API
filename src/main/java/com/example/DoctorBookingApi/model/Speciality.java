package com.example.DoctorBookingApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tbl_speciality")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    @ManyToMany(mappedBy = "speciality")
    Set<Doctor> doctors;

    @OneToMany(mappedBy = "speciality")
    Set<Symptoms> symptoms;
}
