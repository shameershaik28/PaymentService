package dev.shameer.PaymentServiceApr25.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Payment extends BaseModel{
    private String orderId;
    private double amount;
    private String paymentRefNo;
    private LocalDateTime paymentInitTime;
    private LocalDateTime paymentCompletionTime;
    private String paymentStatus;
    private String userId;
}
