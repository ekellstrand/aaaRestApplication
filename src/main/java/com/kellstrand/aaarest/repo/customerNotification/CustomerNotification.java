package com.kellstrand.aaarest.repo.customerNotification;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class CustomerNotification {

    private @Id @GeneratedValue Long id;
    private Long policyHolderId;
    private String notificationType;
    private String notificationData;
    private String status;
    private LocalDate sentDate;


    public CustomerNotification() {

    }

    public CustomerNotification(Long policyHolderId, String notificationType, String notificationData, String status, LocalDate sentDate) {
        this.policyHolderId = policyHolderId;
        this.notificationType = notificationType;
        this.notificationData = notificationData;
        this.status = status;
        this.sentDate = sentDate;
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

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getNotificationData() {
        return notificationData;
    }

    public void setNotificationData(String notificationData) {
        this.notificationData = notificationData;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getSentDate() {
        return sentDate;
    }

    public void setSentDate(LocalDate sentDate) {
        this.sentDate = sentDate;
    }
}
