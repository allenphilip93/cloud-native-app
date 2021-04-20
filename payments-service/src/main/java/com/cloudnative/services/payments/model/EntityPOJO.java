package com.cloudnative.services.payments.model;

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
    private String type;

    @Column(name = "num_installments")
    private int numInstallments;

    @Column
    private double amount;

    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
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
