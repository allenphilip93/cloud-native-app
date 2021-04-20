package com.cloudnative.services.customers.rest.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import io.swagger.v3.oas.annotations.media.Schema;

public class CreateDto {
    
    @Schema(example = "102231a")
    @NotBlank
    private String id;

    @Schema(example = "Paul Jenkins")
    @NotBlank
    private String name;

    @Schema(example = "paul.jenky@gmail.com")
    @NotBlank
    private String email;

    @Schema(example = "Male")
    private String gender;

    @Schema(example = "24")
    @NotBlank
    @Positive
    private int age;

    @Schema(example = "New York")
    private String city;

    @Schema(example = "Washington DC")
    private String state;

    @Schema(example = "USA")
    private String country;

    @Schema(example = "2018-05-20 18:58:59")
    private Date createdOn;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", gender='" + getGender() + "'" +
            ", age='" + getAge() + "'" +
            ", city='" + getCity() + "'" +
            ", state='" + getState() + "'" +
            ", country='" + getCountry() + "'" +
            ", createdOn='" + getCreatedOn() + "'" +
            "}";
    }

}
