package com.example.DoctorBookingApi.controller;

import com.example.DoctorBookingApi.Dto.DoctorDto;
import com.example.DoctorBookingApi.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @GetMapping
    public ResponseEntity booking(@RequestParam int id){

        return bookingService.findDoc(id);
    }
}
