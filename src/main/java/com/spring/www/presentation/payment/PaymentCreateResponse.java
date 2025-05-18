package com.spring.www.presentation.payment;

import lombok.Builder;

@Builder
public record PaymentCreateResponse(Long id) {
    public PaymentCreateResponse {
        if (id == null) {
            throw new IllegalArgumentException("ID 값은 필수입니다.");
        }
    }

    public static PaymentCreateResponse of(Long id) {
        return builder().id(id).build();
    }
}
