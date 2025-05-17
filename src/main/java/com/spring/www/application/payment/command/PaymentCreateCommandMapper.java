package com.spring.www.application.payment.command;

import com.spring.www.presentation.payment.PaymentCreateRequest;
import org.springframework.stereotype.Component;

@Component
public class PaymentCreateCommandMapper {
    public PaymentCreateCommand from(PaymentCreateRequest paymentCreateRequest) {
        return PaymentCreateCommand.builder()
                                   .orderId(paymentCreateRequest.orderId())
                                   .paymentStatus(paymentCreateRequest.paymentStatus())
                                   .paymentMethod(paymentCreateRequest.paymentMethod())
                                   .amount(paymentCreateRequest.amount())
                                   .build();
    }
}
