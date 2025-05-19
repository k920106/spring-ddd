package com.spring.www.presentation.payment;

import com.spring.www.domain.payment.PaymentMethod;
import com.spring.www.domain.payment.PaymentStatus;

public record PaymentCreateRequest(
        Long orderId,
        PaymentStatus paymentStatus,
        PaymentMethod paymentMethod,
        Long amount
) {
}
