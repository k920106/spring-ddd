package com.spring.www.presentation.point;

public record PointUseRequest(
        String accessToken,
        String ci,
        Long pointUse,
        String wkbPaymentNo
) {
}
