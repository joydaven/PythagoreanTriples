package com.jdnegrido.exam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Number {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private int number;

  private String response;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(Integer numb) {
    this.number = numb;
  }

  public String getResponse() {
    return response;
  }

  public void setResponse(String res) {
    this.response = res;
  }
}