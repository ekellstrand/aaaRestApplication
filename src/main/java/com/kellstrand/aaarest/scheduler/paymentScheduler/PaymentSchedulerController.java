package com.kellstrand.aaarest.scheduler.paymentScheduler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentSchedulerController {

    /*
     * 	Process
     * 	- GET Bills that are DUE (not attempted), Locking them to this scheduler before returning
     *  - For Each Bill
     *      - POST /lockBill
     *      - if lock acquired, Process Payment  (could succeed or fail)
     * 	    - POST Payment
     *          - POST a customer notification (If fails, it only logs error, it does not fail payment POST)
     *      - POST /unlockBill
     *
     */
    @GetMapping("/generate_payments")
    public String generatePayments() {
        return "";
    }

    /*
     *  Process
     * - GET Bills that have been locked for an excessive time
     * - Ideally, confirm that the processor indicated is actually gone
     * - POST /unlock so that the bill will get picked up on the next run
     */
    @GetMapping("/release_dead_locks")
    public String releaseDeadLocks() {
        return "";
    }

}
