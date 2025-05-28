package com.kellstrand.aaarest.repo.paymentMethod;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "payment_methods", path = "payment_methods")
public interface PaymentMethodRepo extends JpaRepository<PaymentMethod, Long> {
}
