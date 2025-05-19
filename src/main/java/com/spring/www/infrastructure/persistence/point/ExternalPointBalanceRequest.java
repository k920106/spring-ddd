package com.spring.www.infrastructure.persistence.point;

import lombok.Builder;

@Builder
public record ExternalPointBalanceRequest(String accessToken) {
    public static ExternalPointBalanceRequest from(String accessToken) {
        return builder().accessToken(accessToken).build();
    }
}
