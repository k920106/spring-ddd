package com.spring.www.presentation.order;

import lombok.Builder;

@Builder
public record OrderCreateResponse(Long id) {
    public OrderCreateResponse {
        if (id == null) {
            throw new IllegalArgumentException("ID 값은 필수입니다.");
        }
    }

    public static OrderCreateResponse of(Long id) {
        return builder().id(id).build();
    }
}
