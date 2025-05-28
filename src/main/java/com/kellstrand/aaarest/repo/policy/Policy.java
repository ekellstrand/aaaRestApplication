package com.kellstrand.aaarest.repo.policy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Policy {

    private @Id
    @GeneratedValue Long id;
    private Long policyHolderId;
    private String schedule;
    private BigDecimal paymentAmount;


    public Policy() {

    }

    public Policy(Long policyHolderId, String schedule, BigDecimal paymentAmount) {
        this.policyHolderId = policyHolderId;
        this.schedule = schedule;
        this.paymentAmount = paymentAmount;
    }

    public Long getId() {
        return id;
    }

    public Long getPolicyHolderId() {
        return policyHolderId;
    }

    public void setPolicyHolderId(Long policyHolderId) {
        this.policyHolderId = policyHolderId;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "id=" + id +
                ", policyHolderId=" + policyHolderId +
                ", schedule='" + schedule + '\'' +
                ", paymentAmount=" + paymentAmount +
                '}';
    }
}
