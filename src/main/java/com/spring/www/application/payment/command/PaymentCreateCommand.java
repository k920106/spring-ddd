package com.spring.www.application.payment.command;

import com.spring.www.infrastructure.persistence.payment.PaymentMethod;
import com.spring.www.infrastructure.persistence.payment.PaymentStatus;
import lombok.Builder;

@Builder
public record PaymentCreateCommand(
        Long orderId,
        PaymentStatus paymentStatus,
        PaymentMethod paymentMethod,
        Long amount
) {
}
