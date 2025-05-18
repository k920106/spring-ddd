package com.spring.www.presentation.point;

import lombok.Builder;

@Builder
public record PointUseResponse(String wkbPaymentNo) {
    public PointUseResponse {
        if (wkbPaymentNo == null || wkbPaymentNo.isBlank()) {
            throw new IllegalArgumentException("wkbPaymentNo 값은 필수입니다.");
        }
    }

    public static PointUseResponse of(String wkbPaymentNo) {
        return builder().wkbPaymentNo(wkbPaymentNo).build();
    }
}
