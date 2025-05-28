package com.kellstrand.aaarest;

import com.kellstrand.aaarest.repo.bill.Bill;
import com.kellstrand.aaarest.repo.bill.BillRepo;
import com.kellstrand.aaarest.repo.payment.Payment;
import com.kellstrand.aaarest.repo.payment.PaymentRepo;
import com.kellstrand.aaarest.repo.paymentMethod.PaymentMethod;
import com.kellstrand.aaarest.repo.paymentMethod.PaymentMethodRepo;
import com.kellstrand.aaarest.repo.policy.Policy;
import com.kellstrand.aaarest.repo.policy.PolicyRepo;
import com.kellstrand.aaarest.repo.policyHolder.PolicyHolder;
import com.kellstrand.aaarest.repo.policyHolder.PolicyHolderRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
public class DataLoader {

    private static final Logger log = LoggerFactory.getLogger(DataLoader.class);

    @Bean
    CommandLineRunner initDatabase(PolicyHolderRepo policyHolderRepo, PaymentMethodRepo paymentMethodRepo, PolicyRepo policyRepo, BillRepo billRepo, PaymentRepo paymentRepo) {
        PolicyHolder ph1 = policyHolderRepo.save(new PolicyHolder("John", "Doe"));
        PolicyHolder ph2 = policyHolderRepo.save(new PolicyHolder("Jane", "Doe"));

        PaymentMethod pm1 = paymentMethodRepo.save(new PaymentMethod(ph1.getId(), "Visa", "1111-2222-3333-4444"));

        Policy p1 = policyRepo.save(new Policy(ph1.getId(), "Monthly", new BigDecimal("25.45")));
        Policy p2 = policyRepo.save(new Policy(ph2.getId(), "Monthly", new BigDecimal("18.32")));

        Bill bill1 = billRepo.save(new Bill(ph1.getId(), LocalDate.now(), LocalDate.now().minusDays(15), new BigDecimal("25.45")));
        Bill bill2 = billRepo.save(new Bill(ph1.getId(), LocalDate.now(), LocalDate.now().plusDays(15), new BigDecimal("18.32"), "PAID"));
        Bill bill3 = billRepo.save(new Bill(ph1.getId(), LocalDate.now(), LocalDate.now().plusDays(12), new BigDecimal("19.44"), "PAID"));

        Payment payment1 = paymentRepo.save(new Payment(ph1.getId(), bill1.getId(), pm1.getId(), LocalDate.now().plusDays(1), bill1.getPaymentAmount(), "FAIL"));

        return args -> {
            log.info("Preloading " + ph1);
            log.info("Preloading " + ph2);

            log.info("Preloading " + pm1);

            log.info("Preloading " + p1);
            log.info("Preloading " + p2);

            log.info("Preloading " + bill1);
            log.info("Preloading " + bill2);
            log.info("Preloading " + bill3);

            log.info("Preloading " + payment1);

        };
    }
}
