package com.spring.www.infrastructure.persistence.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OrderException extends RuntimeException {
    private final OrderExceptionResult orderExceptionResult;
}
