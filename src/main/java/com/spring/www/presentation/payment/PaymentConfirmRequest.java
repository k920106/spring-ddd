package com.spring.www.presentation.payment;

import com.spring.www.infrastructure.persistence.payment.PaymentMethod;

public record PaymentConfirmRequest(
        PaymentMethod paymentMethod,
        String wkbPaymentNo,
        Integer pointUse
) {
}
