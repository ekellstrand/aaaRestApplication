package com.kellstrand.aaarest.repo.customerNotification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "customer_notifications", path = "customer_notifications")
public interface CustomerNotificationRepo extends JpaRepository<CustomerNotification, Long> {
    List<CustomerNotification> findByStatus(@Param("status") String status);
}
