package com.kellstrand.aaarest.repo.bill;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Bill {

    private @Id
    @GeneratedValue Long id;
    private Long policyHolderId;
    private LocalDate creationDate;
    private LocalDate dueDate;
    private BigDecimal paymentAmount;
    private String status = "DUE";      // TODO: Use Enum for better validation and knowing all possible values
    private String processingStatus = "CREATED";
    private String processingByProcess;     // Process that has locked this object for processing
    private Date processingStartedTime;     // Time the processor has locked this object


    public Bill() {

    }

    public Bill(Long policyHolderId, LocalDate creationDate, LocalDate dueDate, BigDecimal paymentAmount) {
        this.policyHolderId = policyHolderId;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.paymentAmount = paymentAmount;
    }

    public Bill(Long policyHolderId, LocalDate creationDate, LocalDate dueDate, BigDecimal paymentAmount, String status) {
        this.policyHolderId = policyHolderId;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.paymentAmount = paymentAmount;
        this.status = status;
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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", policyHolderId=" + policyHolderId +
                ", creationDate=" + creationDate +
                ", dueDate=" + dueDate +
                ", paymentAmount=" + paymentAmount +
                ", Status='" + status + '\'' +
                '}';
    }

}
