package com.cloudnative.services.products.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class CreateProductDto {

    @Schema(example = "102231a")
    @NotBlank
    private String id;

    @Schema(example = "Electronics")
    @NotBlank
    private String category;

    @Schema(example = "Laptops")
    @NotBlank
    private String subcategory;

    @Schema(example = "Apple")
    private String brand;

    @Schema(example = "999.99")
    @NotBlank
    @Positive
    private double price;

    @Schema(example = "13 inch macbook pro grey 2020")
    private String descr;

    @Schema(example = "2018-05-20 18:58:59")
    private Date addedOn;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return this.subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescr() {
        return this.descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Date getAddedOn() {
        return this.addedOn;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", category='" + getCategory() + "'" +
            ", subcategory='" + getSubcategory() + "'" +
            ", brand='" + getBrand() + "'" +
            ", price='" + getPrice() + "'" +
            ", descr='" + getDescr() + "'" +
            ", addedOn='" + getAddedOn() + "'" +
            "}";
    }

}
