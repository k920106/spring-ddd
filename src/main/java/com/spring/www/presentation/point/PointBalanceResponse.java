package com.spring.www.presentation.point;

import lombok.Builder;

@Builder
public record PointBalanceResponse(Long balance) {
    public PointBalanceResponse {
        if (balance == null) {
            throw new IllegalArgumentException("balance 값은 필수입니다.");
        }
    }

    public static PointBalanceResponse of(Long balance) {
        return builder().balance(balance).build();
    }
}
