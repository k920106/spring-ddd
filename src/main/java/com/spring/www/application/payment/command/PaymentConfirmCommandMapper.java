package com.spring.www.application.payment.command;

import com.spring.www.presentation.payment.PaymentConfirmRequest;
import org.springframework.stereotype.Component;

@Component
public class PaymentConfirmCommandMapper {
    public PaymentConfirmCommand from(PaymentConfirmRequest paymentConfirmRequest) {
        return PaymentConfirmCommand.builder()
//                                    .paymentMethod()
//                                    .wkbPaymentNo()
//                                    .pointUse()
                                    .build();
    }
}
