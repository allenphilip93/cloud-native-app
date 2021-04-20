package com.cloudnative.services.reviews.model;

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
    private int score;
    
    @Column
    private String comment;

    @Column(name = "added_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "order_id")
    private String orderId;
    

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

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", score='" + getScore() + "'" +
            ", comment='" + getComment() + "'" +
            ", createdOn='" + getCreatedOn() + "'" +
            ", customerId='" + getCustomerId() + "'" +
            ", productId='" + getProductId() + "'" +
            ", orderId='" + getOrderId() + "'" +
            "}";
    }

}
