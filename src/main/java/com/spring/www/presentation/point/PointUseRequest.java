package com.spring.www.presentation.point;

public record PointUseRequest(
        String accessToken,
        String wkbPaymentNo,
        Long pointUse
) {
}
