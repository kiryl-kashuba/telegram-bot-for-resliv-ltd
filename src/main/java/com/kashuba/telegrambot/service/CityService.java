package com.kashuba.telegrambot.service;

import com.kashuba.telegrambot.dto.CityDto;

public interface CityService extends Crud<CityDto> {
  String findByName(String message);
}