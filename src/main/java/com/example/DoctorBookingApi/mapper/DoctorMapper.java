package com.example.DoctorBookingApi.mapper;

import com.example.DoctorBookingApi.Dto.DoctorDto;
import com.example.DoctorBookingApi.model.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface DoctorMapper {
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    List<DoctorDto> modelToDtos(List<Doctor> doctors);

    DoctorDto modelToDto(Doctor doctor);
    Doctor dtoToModel(DoctorDto doctorDto);

}
