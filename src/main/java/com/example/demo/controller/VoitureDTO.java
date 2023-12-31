package com.example.demo.controller;

import java.time.LocalDate;

public class VoitureDTO {

    private String brand;
    private String model;
    private Integer year;
    private String color;
    private Integer age;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAge() {
        if(year == null)
            return 0;
        else {
            LocalDate now = LocalDate.now();
            return now.getYear() - year;
        }
    }

}
