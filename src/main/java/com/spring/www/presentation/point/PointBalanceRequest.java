package com.spring.www.presentation.point;

public record PointBalanceRequest(
        String accessToken,
        String ci,
        String companyId
) {
}
