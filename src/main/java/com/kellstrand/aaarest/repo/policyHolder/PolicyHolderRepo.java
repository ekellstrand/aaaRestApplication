package com.kellstrand.aaarest.repo.policyHolder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "policy_holders", path = "policy_holders")
public interface PolicyHolderRepo extends JpaRepository<PolicyHolder, Long> {
}
