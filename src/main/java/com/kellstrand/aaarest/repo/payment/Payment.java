package com.kellstrand.aaarest.repo.payment;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Payment {

    private @Id
    @GeneratedValue Long id;
    private Long policyHolderId;            //  Denormalized for Performance
    private Long billId;
    private Long paymentMethodId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate paymentDate;
    private BigDecimal amount;
    private String status = "UNKOWN";   // TODO: Use Enum for better validation and knowing all possible values
    public Payment() {

    }

    public Payment(Long policyHolderId, Long billId, Long paymentMethodId, LocalDate paymentDate, BigDecimal amount, String status) {
        this.policyHolderId = policyHolderId;
        this.billId = billId;
        this.paymentMethodId = paymentMethodId;
        this.paymentDate = paymentDate;
        this.amount = amount;
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

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", policyHolderId=" + policyHolderId +
                ", billId=" + billId +
                ", paymentMethodId=" + paymentMethodId +
                ", paymentDate=" + paymentDate +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }

    public Long getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
