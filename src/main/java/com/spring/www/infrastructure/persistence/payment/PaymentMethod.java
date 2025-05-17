package com.spring.www.infrastructure.persistence.payment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentMethod {
    CARD("체크/신용카드"),
    POINT("포인트")
    ;

    private final String message;
}
