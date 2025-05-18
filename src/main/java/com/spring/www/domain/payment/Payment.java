package com.spring.www.domain.payment;

import com.spring.www.infrastructure.persistence.payment.PaymentMethod;
import com.spring.www.infrastructure.persistence.payment.PaymentStatus;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record Payment(
        Long id,
        Long orderId,
        PaymentStatus paymentStatus,
        PaymentMethod paymentMethod,
        Long amount,
        LocalDateTime paidAt,
        LocalDateTime canceledAt
) {
    public Payment {
        //유효성 검사
        //throw exception
    }
}
