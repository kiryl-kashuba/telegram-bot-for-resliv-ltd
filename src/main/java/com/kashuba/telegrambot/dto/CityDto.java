package com.kashuba.telegrambot.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CityDto {

  private long id;
  private String name;
  private String message;

  @JsonCreator
  public CityDto(
      @JsonProperty("name") String name,
      @JsonProperty("message") String message) {
    this.name = name;
    this.message = message;
  }
}
