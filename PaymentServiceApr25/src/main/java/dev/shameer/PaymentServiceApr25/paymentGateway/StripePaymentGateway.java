package dev.shameer.PaymentServiceApr25.paymentGateway;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.stereotype.Component;

@Component("stripePayment")
public class StripePaymentGateway implements PaymentGateway{

    private String stripeAPIKey = "something";


    @Override
    public String generatePaymentLink(String orderId, long amount, String userId) throws StripeException {
        Stripe.apiKey = stripeAPIKey;

        // price parameter object -> contains all necessary metadata for pricing
        PriceCreateParams priceCreateParams =
                PriceCreateParams.builder()
                        .setCurrency("inr")
                        .setUnitAmount(amount)
                        .setProductData(
                                PriceCreateParams.ProductData.builder()
                                        .setName("ProductName").build()
                        )
                        .build();

        // price object is created using price params
        Price price = Price.create(priceCreateParams);


        // paymentlink params creation -> contains all necessary metadata for payment link
        PaymentLinkCreateParams paymentLinkCreateParams =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(1L) // 1L is long, 1 would be integer
                                        .build()
                        )
                        .setAfterCompletion(
                                PaymentLinkCreateParams.AfterCompletion.builder()
                                        .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                        .setRedirect(PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                                .setUrl("callback URL")
                                                .build()
                                        )
                                        .build()

                        )
                        .build();

        PaymentLink paymentLink = PaymentLink.create(paymentLinkCreateParams);
        return paymentLink.toString();
    }
}
