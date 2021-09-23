package com.kashuba.telegrambot.service;

import com.kashuba.telegrambot.dto.CityDto;
import com.kashuba.telegrambot.entity.City;

public interface CityService extends Crud<CityDto> {

  String findByName(String message);

  City update(CityDto cityDto);
}