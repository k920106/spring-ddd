package com.spring.www.presentation.config.exception;

import com.spring.www.infrastructure.persistence.order.OrderException;
import com.spring.www.presentation.common.CommonResponse;
import com.sun.jdi.request.InvalidRequestStateException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(row -> errors.put("error", row.getDefaultMessage()));
        CommonResponse<?> responseDto = new CommonResponse<>(httpStatus, "BAD REQUEST", errors);
        exception.printStackTrace();
        return new ResponseEntity<>(responseDto, httpStatus);
    }

    @ExceptionHandler(InvalidRequestStateException.class)
    public ResponseEntity<Object> handleInvalidRequestException(InvalidRequestStateException exception) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        Map<String, String> errors = new HashMap<>();
        errors.put("error", exception.getMessage());
        CommonResponse<?> responseDto = new CommonResponse<>(httpStatus, "BAD REQUEST", errors);
        exception.printStackTrace();
        return new ResponseEntity<>(responseDto, httpStatus);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> constraintViolationException(ConstraintViolationException exception) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        Map<String, String> errors = new HashMap<>();
        exception.getConstraintViolations().forEach(row -> errors.put("error", row.getMessage()));
        CommonResponse<?> responseDto = new CommonResponse<>(httpStatus, "BAD REQUEST", errors);
        exception.printStackTrace();
        return new ResponseEntity<>(responseDto, httpStatus);
    }

    @ExceptionHandler(OrderException.class)
    public final ResponseEntity<Object> handleOrderException(OrderException exception) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        Map<String, String> errors = new HashMap<>();
        errors.put("error", exception.getOrderExceptionResult().getMessage());
        CommonResponse<?> responseDto = new CommonResponse<>(httpStatus, httpStatus.name(), errors);
        exception.printStackTrace();
        return new ResponseEntity<>(responseDto, httpStatus);
    }

    @ExceptionHandler(value = InvalidDataAccessApiUsageException.class)
    public ResponseEntity<Object> invalidDataAccessApiUsageException(InvalidDataAccessApiUsageException exception) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        Map<String, String> errors = Collections.singletonMap("error", exception.getMessage());
        CommonResponse<?> responseDto = new CommonResponse<>(httpStatus, "BAD REQUEST", errors);
        exception.printStackTrace();
        return new ResponseEntity<>(responseDto, httpStatus);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> exception(Exception exception) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        CommonResponse<?> responseDto = new CommonResponse<>(httpStatus, exception.getClass().getSimpleName(), exception.getMessage());
        exception.printStackTrace();
        return new ResponseEntity<>(responseDto, httpStatus);
    }
}
