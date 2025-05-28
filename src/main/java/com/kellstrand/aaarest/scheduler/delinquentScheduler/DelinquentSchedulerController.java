package com.kellstrand.aaarest.scheduler.delinquentScheduler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DelinquentSchedulerController {

    /*
     * 	Process
     * 		- GET unpaid bills that are X days past due
     *    	- POST a Customer Notification
     */
    @GetMapping("/generate_delinquent_notifications")
    public String generateDelinquentNotifications() {
        return "";
    }

}
