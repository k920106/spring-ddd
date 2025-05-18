package com.spring.www.presentation.payment;

import lombok.Builder;

@Builder
public record PaymentConfirmResponse() {
    public static PaymentConfirmResponse of() {
        return builder().build();
    }
}
