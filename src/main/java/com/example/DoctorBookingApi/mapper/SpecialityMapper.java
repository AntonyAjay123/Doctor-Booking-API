package com.example.DoctorBookingApi.mapper;

import com.example.DoctorBookingApi.Dto.SpecialityDto;
import com.example.DoctorBookingApi.model.Speciality;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface SpecialityMapper {
    SpecialityDto modelToDto(Speciality speciality);
    Set<SpecialityDto> modelToDtos(List<Speciality> specialities);

    Speciality dtoToModel(SpecialityDto specialityDto);

}
