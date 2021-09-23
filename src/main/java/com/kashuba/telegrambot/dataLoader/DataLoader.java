package com.kashuba.telegrambot.dataLoader;

import com.kashuba.telegrambot.dao.CityRepository;
import com.kashuba.telegrambot.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

  @Autowired
  private CityRepository cityRepository;

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public void run(ApplicationArguments args) {
    jdbcTemplate.execute("drop table IF EXISTS city");
    jdbcTemplate.execute("create table city(id serial, name varchar(200), message varchar(200))");
    cityRepository.save(new City("Брест", "В Бресте обязательно нужно зайти в Пинту. Это самый ламповый бар "
        + "города"));
    cityRepository.save(new City("Могилев", "На львином мосту очень много пауков"));
    cityRepository.save(new City("Киев", "Слава украине!"));
    cityRepository.save(new City("Лондон", "I love the spirit of great London that I feel everywhere here"));
    cityRepository.save(new City("Гродно", "В Гродно тяжело найти место, где можно поесть блинов"));
    cityRepository.save(new City("Минск", "Минск.. Ты и так все про него знаешь"));
    cityRepository.save(new City("Гомель", "Я не был в Гомеле (((9("));
    cityRepository.save(new City("Витебск", "И в Витебске я не был.."));
    cityRepository.save(new City("Львов", "Львов - афигенный город, чтобы хорошо провести время"));
    cityRepository.save(new City("Москва", "Все в Москву лезут, будто она резиновая(с)"));
  }
}
