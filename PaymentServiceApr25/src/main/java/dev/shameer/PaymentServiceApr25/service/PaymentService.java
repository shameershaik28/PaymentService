package dev.shameer.PaymentServiceApr25.service;

import com.stripe.exception.StripeException;
import dev.shameer.PaymentServiceApr25.paymentGateway.PaymentGateway;
import dev.shameer.PaymentServiceApr25.respository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    @Qualifier("stripePayment")
    private PaymentGateway paymentGateway;

    public String generatePaymentLink(String orderId, String userId, long amount) throws StripeException {
        String paymentLink = paymentGateway.generatePaymentLink(orderId, amount, userId);
        return paymentLink;
    }
}
