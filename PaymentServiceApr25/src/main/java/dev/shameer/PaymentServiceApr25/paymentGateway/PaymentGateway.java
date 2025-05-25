package dev.shameer.PaymentServiceApr25.paymentGateway;

public interface PaymentGateway {
    String generatePaymentLink(String orderId, double amount, String userId);
}
