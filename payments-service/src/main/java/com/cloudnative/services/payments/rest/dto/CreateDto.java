package com.cloudnative.services.payments.rest.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import io.swagger.v3.oas.annotations.media.Schema;

public class CreateDto {
    
    @Schema(example = "102231a")
    @NotBlank
    private String id;

    @Schema(example = "Credit Card")
    @NotBlank
    private String type;

    @Schema(example = "6")
    @NotBlank
    @Positive
    private int numInstallments;

    @Schema(example = "199.97")
    @NotBlank
    @Positive
    private double amount;

    @Schema(example = "2018-05-20 18:58:59")
    private Date createdOn;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumInstallments() {
        return this.numInstallments;
    }

    public void setNumInstallments(int numInstallments) {
        this.numInstallments = numInstallments;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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
            ", type='" + getType() + "'" +
            ", numInstallments='" + getNumInstallments() + "'" +
            ", amount='" + getAmount() + "'" +
            ", createdOn='" + getCreatedOn() + "'" +
            "}";
    }

}
