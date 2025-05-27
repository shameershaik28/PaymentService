package dev.shameer.PaymentServiceApr25.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentLinkReqDTO {
    private String orderId;
    private String userId;
    private long amount;
}
