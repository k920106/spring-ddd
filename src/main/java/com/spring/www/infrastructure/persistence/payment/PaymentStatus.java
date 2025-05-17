package com.spring.www.infrastructure.persistence.payment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentStatus {
    PENDING("결제대기"),
    COMPLETED("결제완료"),
    FAILED("결제실패")
    ;

    private final String message;
}
