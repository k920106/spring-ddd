package com.spring.www.application.payment.command;

import com.spring.www.domain.payment.PaymentMethod;
import com.spring.www.domain.payment.PaymentStatus;
import lombok.Builder;

@Builder
public record PaymentCreateCommand(
        Long orderId,
        PaymentStatus paymentStatus,
        PaymentMethod paymentMethod,
        Long amount
) {
}
