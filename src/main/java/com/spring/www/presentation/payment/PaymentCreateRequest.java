package com.spring.www.presentation.payment;

import com.spring.www.infrastructure.persistence.payment.PaymentMethod;
import com.spring.www.infrastructure.persistence.payment.PaymentStatus;

public record PaymentCreateRequest(
        Long orderId,
        PaymentStatus paymentStatus,
        PaymentMethod paymentMethod,
        Long amount
) {
}
