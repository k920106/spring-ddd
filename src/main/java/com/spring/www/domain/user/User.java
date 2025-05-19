package com.spring.www.domain.user;

import lombok.Builder;

@Builder
public record User(
    String companyId,
    String accessToken,
    String ci
) {
}
