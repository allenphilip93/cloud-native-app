package com.cloudnative.services.reviews.rest.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import io.swagger.v3.oas.annotations.media.Schema;

public class CreateDto {
    
    @Schema(example = "102231a")
    @NotBlank
    private String id;

    @Schema(example = "24")
    @NotBlank
    @Positive
    private int score;

    @Schema(example = "Paul Jenkins")
    @NotBlank
    private String comment;

    @Schema(example = "2018-05-20 18:58:59")
    private Date createdOn;

    @Schema(example = "10923")
    @NotBlank
    private String orderId;

    @Schema(example = "cb2aj28j")
    @NotBlank
    private String customerId;

    @Schema(example = "oisj29haa")
    @NotBlank
    private String productId;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", score='" + getScore() + "'" +
            ", comment='" + getComment() + "'" +
            ", createdOn='" + getCreatedOn() + "'" +
            ", orderId='" + getOrderId() + "'" +
            ", customerId='" + getCustomerId() + "'" +
            ", productId='" + getProductId() + "'" +
            "}";
    }

}
