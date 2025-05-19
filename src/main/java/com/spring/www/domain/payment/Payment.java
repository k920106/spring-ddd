package com.spring.www.domain.payment;

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
