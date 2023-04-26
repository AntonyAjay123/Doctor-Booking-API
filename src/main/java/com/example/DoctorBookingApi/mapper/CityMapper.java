package com.example.DoctorBookingApi.mapper;

import com.example.DoctorBookingApi.Dto.CityDto;
import com.example.DoctorBookingApi.model.City;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {
    CityMapper INSTANCE= Mappers.getMapper(CityMapper.class);
    CityDto modelToDto(City city);

    List<CityDto> modelToDtos(List<City> cityList);
    City dtoToModel(CityDto cityDto);

}
