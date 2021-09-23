package com.kashuba.telegrambot.converter;

import com.kashuba.telegrambot.dto.CityDto;
import com.kashuba.telegrambot.entity.City;
import org.springframework.stereotype.Component;

@Component
public class CityConverter {

  public City toModel(CityDto cityDto){
    return new City(cityDto.getId  (),
        cityDto.getName(),
        cityDto.getMessage());
  }

  public CityDto toDto(City city){
    return new CityDto(city.getId(),
        city.getName(),
        city.getMessage());
  }
}
