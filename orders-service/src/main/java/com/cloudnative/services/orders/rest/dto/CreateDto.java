package com.cloudnative.services.orders.rest.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;

public class CreateDto {
    
    @Schema(example = "102231a")
    @NotBlank
    private String id;

    @Schema(example = "p1992a")
    @NotBlank
    private String productId;

    @Schema(example = "c2uu82")
    @NotBlank
    private String customerId;

    @Schema(example = "992871af")
    @NotBlank
    private String sellerId;

    @Schema(example = "992871af")
    @NotBlank
    private String paymentId;

    @Schema(example = "2018-05-20 18:58:59")
    private Date createdOn;

    @Schema(example = "2018-05-29 18:58:59")
    private Date deliveredOn;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPaymentId() {
        return this.paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Date getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getDeliveredOn() {
        return this.deliveredOn;
    }

    public void setDeliveredOn(Date deliveredOn) {
        this.deliveredOn = deliveredOn;
    }


    public String getSellerId() {
        return this.sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", productId='" + getProductId() + "'" +
            ", customerId='" + getCustomerId() + "'" +
            ", sellerId='" + getSellerId() + "'" +
            ", paymentId='" + getPaymentId() + "'" +
            ", createdOn='" + getCreatedOn() + "'" +
            ", deliveredOn='" + getDeliveredOn() + "'" +
            "}";
    }

}
