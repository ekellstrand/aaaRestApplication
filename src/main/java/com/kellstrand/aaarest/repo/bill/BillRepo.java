package com.kellstrand.aaarest.repo.bill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "bills", path = "bills")
public interface BillRepo extends JpaRepository<Bill, Long> {
    // curl -i "http://localhost:8080/bills/search/findByStatus?status=PAID"
    List<Bill> findByStatus(@Param("status") String status);

    List<Bill> findByDueDateBeforeAndStatus(@Param("dueDate") LocalDate dueDate, String status);
}
