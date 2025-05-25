package dev.shameer.PaymentServiceApr25.service;

import dev.shameer.PaymentServiceApr25.paymentGateway.PaymentGateway;
import dev.shameer.PaymentServiceApr25.respository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    //@Autowired
    private PaymentGateway paymentGateway;

    public String generatePaymentLink(String orderId, String userId, double amount){
        String paymentLink = paymentGateway.generatePaymentLink(orderId, amount, userId);
        return paymentLink;
    }
}
