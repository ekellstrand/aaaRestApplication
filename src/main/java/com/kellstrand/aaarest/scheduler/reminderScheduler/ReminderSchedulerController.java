package com.kellstrand.aaarest.scheduler.reminderScheduler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReminderSchedulerController {

    /*
     * 	Process
     * 	- GET unpaid bills that are X days before due
     *      - POST a customer notification (If fails, it only logs error, it does not fail payment POST)
     */
    @GetMapping("/generate_reminders")
    public String generateReminders() {
        return "";
    }

}
