package com.spring.www.infrastructure.persistence.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderExceptionResult {
    NOT_FOUND_ORDER("등록된 주문을 찾을 수 없습니다")
    ;
    private final String message;
}
