package com.spring.www.application.payment.command;

import com.spring.www.domain.payment.PaymentMethod;
import lombok.Builder;

@Builder
public record PaymentConfirmCommand(
        PaymentMethod paymentMethod,
        String wkbPaymentNo,
        Integer pointUse
) {
}
