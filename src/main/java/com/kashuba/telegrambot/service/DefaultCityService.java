package com.kashuba.telegrambot.service;

import com.kashuba.telegrambot.converter.CityConverter;
import com.kashuba.telegrambot.dao.CityRepository;
import com.kashuba.telegrambot.dto.CityDto;
import com.kashuba.telegrambot.entity.City;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultCityService implements CityService {

  @Autowired
  private CityRepository cityRepository;

  @Autowired
  private CityConverter converter;

  @Override
  public Long create(CityDto cityDto) {
    City city = converter.toModel(cityDto);
    return (cityRepository.saveAndFlush(city)).getId();
  }

//  public int update(EmployeeDto employeeDto) {
//    return 0;
//  }

  @Override
  public void delete(Long id) {
    cityRepository.deleteById(id);
  }

  @Override
  public List<CityDto> getAll() {
    return cityRepository.findAll()
        .stream().map(converter::toDto).collect(Collectors.toList());
  }

  @Override
  public Optional<CityDto> get(Long id) {
    return Optional.of(converter.toDto(cityRepository.findById(id).get()));
  }

  @Override
  public String findByName(String message) {
    City city = cityRepository.findByName(message);
    return city.getMessage();
  }
}