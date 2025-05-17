package com.spring.www.domain.order;

import lombok.Builder;

@Builder
public record OrderUser(
        String odrerNm,
        String odrerTelNo
) {
}
