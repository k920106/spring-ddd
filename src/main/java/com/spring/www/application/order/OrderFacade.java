package com.spring.www.application.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.www.application.order.command.OrderCreateCommand;
import com.spring.www.domain.order.Order;
import com.spring.www.domain.order.OrderService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class OrderFacade {
    private final OrderService orderService;
    private final ObjectMapper objectMapper;
    private final Validator validator;

    @Transactional
    public Long createOrder(OrderCreateCommand command) {
        Order convertedOrder = objectMapper.convertValue(command, Order.class);
        validateConvertedOrder(convertedOrder);
        Order savedOrder = orderService.createOrder(convertedOrder);
        return savedOrder.id();
    }

    private void validateConvertedOrder(Order order) {
        Set<ConstraintViolation<Order>> violations = validator.validate(order);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
