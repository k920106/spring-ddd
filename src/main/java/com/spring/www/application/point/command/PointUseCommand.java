package com.spring.www.application.point.command;

import lombok.Builder;

@Builder
public record PointUseCommand(
        String accessToken,
        String wkbPaymentNo,
        Long pointUse
) {
}
