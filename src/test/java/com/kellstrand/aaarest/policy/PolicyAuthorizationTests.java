package com.kellstrand.aaarest.policy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PolicyAuthorizationTests {

    @Test
    void contextLoads() {
    }

    //TODO:  Implement tests to ensure caller can access ONLY the APIs it should (probably by RBAC)

    //TODO:  Implement tests to ensure caller can access ONLY appropriate data from API calls
    //      (Assuming different data can be returned by different RBAC Roles..
    //      This could be a very bad idea - use with caution)

    //TODO:  Implement tests to ensure API calls can NOT operate on another user's data
}
