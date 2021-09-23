package com.kashuba.telegrambot.controller;

import com.kashuba.telegrambot.dto.CityDto;
import com.kashuba.telegrambot.service.CityService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CityController {

  @Autowired
  private CityService cityService;

  @PostMapping
  public Long create(@RequestBody CityDto cityDto) {
    return cityService.create(cityDto);
  }

  @GetMapping("/{id}")
  public Optional<CityDto> get(@PathVariable Long id) {
    return cityService.get(id);
  }

  @GetMapping("/all")
  public List<CityDto> getAll() {
    return cityService.getAll();
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    cityService.delete(id);
  }

  @PostMapping("/find-city")
  public String findByName(@RequestBody CityDto cityDto) {
    return cityService.findByName(cityDto.getName());
  }



//  @PutMapping
//  public int update(@Valid @RequestBody EmployeeDto employeeDto) {
//    return defaultEmployeeService.update(employeeDto);
//  }
}