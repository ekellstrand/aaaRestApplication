package com.kellstrand.aaarest.repo.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "payments", path = "payments")
public interface PaymentRepo extends JpaRepository<Payment, Long> {
    // curl -i "http://localhost:8080/payments/search/findByStatus?status=PAID"
    List<Payment> findByStatus(@Param("status") String status);

    // TODO: This query will return all failed payments.  It needs to be deduped so that multiple failed payments don't attempt to retry X times per run.  I should probably add a PaymentStatus field on the Bill to resolve this.
    @Query("select p from Payment p left outer join Bill b on (p.billId=b.id) where p.status = \"FAIL\" AND b.status=\"DUE\"")
    List<Payment> findFailedPayments();
}
