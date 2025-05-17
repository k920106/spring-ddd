package com.spring.www.application.order.command;

import com.spring.www.infrastructure.persistence.payment.PaymentMethod;
import lombok.Builder;

@Builder
public record PaymentConfirmCommand(
        PaymentMethod paymentMethod,
        String wkbPaymentNo,
        Integer pointUse
) {
}
