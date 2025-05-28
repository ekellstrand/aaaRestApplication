package com.kellstrand.aaarest.scheduler.billScheduler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillSchedulerController {

    /*
     * 	Process
     * 		- GET Policies that don't have successful payment for this month
     *      - Calculate payment amount
	 *      - POST Bill  (Must fail if bill already exists for this policy/this month)
	 *          - POST a customer notification (If fails, it only logs error, it does not fail payment POST)
     */

    @GetMapping("/generate_bills")
    public String generateBills() {
        return "";
    }

}
