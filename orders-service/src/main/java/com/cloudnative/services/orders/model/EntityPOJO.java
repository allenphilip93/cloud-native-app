package com.cloudnative.services.orders.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class EntityPOJO {
    
    @Column
    @Id
    private String id;

    @Column
    private String customerId;

    @Column
    private String productId;

    @Column
    private String paymentId;

    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Column(name = "delivered_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveredOn;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", customerId='" + getCustomerId() + "'" +
            ", productId='" + getProductId() + "'" +
            ", paymentId='" + getPaymentId() + "'" +
            ", createdOn='" + getCreatedOn() + "'" +
            ", deliveredOn='" + getDeliveredOn() + "'" +
            "}";
    }

}
