package com.spring.www.infrastructure.persistence.point;

import lombok.Builder;

@Builder
public record ExternalPointBalanceSktRequest(String ci) {
    public static ExternalPointBalanceSktRequest from(String ci) {
        return builder().ci(ci).build();
    }
}
