package com.example.DoctorBookingApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "tbl_symptoms")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Symptoms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    @ManyToOne
    @JoinColumn(name="Speciality")
    Speciality speciality;

    @OneToMany(mappedBy = "symptoms")
    Set<Patient> patients;
}
