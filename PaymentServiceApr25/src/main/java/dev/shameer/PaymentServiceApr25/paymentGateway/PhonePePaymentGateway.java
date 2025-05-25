package dev.shameer.PaymentServiceApr25.paymentGateway;

import org.springframework.stereotype.Component;

@Component("phonepePayment")
public class PhonePePaymentGateway implements PaymentGateway{
    @Override
    public String generatePaymentLink(String orderId, long amount, String userId) {
        return "";
    }
}
