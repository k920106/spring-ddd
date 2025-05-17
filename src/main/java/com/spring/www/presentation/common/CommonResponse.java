package com.spring.www.presentation.common;

import org.springframework.http.HttpStatus;

public record CommonResponse<T>(
    Integer code,
    String message,
    T data
) {
    public CommonResponse(T data) {
        this(HttpStatus.OK.value(), HttpStatus.OK.name(), data);
    }

    public CommonResponse(HttpStatus status, String msg, T data) {
        this(status.value(), msg, data);
    }
}
