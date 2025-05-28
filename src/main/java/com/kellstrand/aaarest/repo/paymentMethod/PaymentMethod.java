package com.kellstrand.aaarest.repo.paymentMethod;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class PaymentMethod {

    private @Id
    @GeneratedValue Long id;
    private Long policyHolderId;            //  Denormalized for Performance
    private String paymentMethod;   // TODO: Use Enum (or likely a table) for better validation and knowing all possible values
    private String paymentDetails;  // Placeholder to abstract away details not relevant to this example  (card number, etc)

    public PaymentMethod() {

    }

    public PaymentMethod(Long policyHolderId, String paymentMethod, String paymentDetails) {
        this.policyHolderId = policyHolderId;
        this.paymentMethod = paymentMethod;
        this.paymentDetails = paymentDetails;
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "id=" + id +
                ", policyHolderId=" + policyHolderId +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentDetails='" + paymentDetails + '\'' +
                '}';
    }
}
