package dev.shameer.PaymentServiceApr25.respository;

import dev.shameer.PaymentServiceApr25.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
