package com.kellstrand.aaarest.repo.policy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "policies", path = "policies")
public interface PolicyRepo extends JpaRepository<Policy, Long> {
}
