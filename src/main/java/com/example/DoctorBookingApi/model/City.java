package com.example.DoctorBookingApi.model;

import jakarta.persistence.*;
import lombok.*;

import javax.print.Doc;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tbl_city")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;

    @OneToMany(mappedBy = "city")
    Set<Doctor> doctors=new HashSet<>();

    @OneToMany(mappedBy = "city")
    Set<Patient> patients=new HashSet<>();


}
