package com.kashuba.telegrambot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "city")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class City {

  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  @Column(name = "id", nullable = true)
  private long id;
  @Column(name = "name", nullable = true)
  private String name;
  @Column(name = "message")
  private String message;

  public City(String name, String message) {
    this.name = name;
    this.message = message;
  }

}
