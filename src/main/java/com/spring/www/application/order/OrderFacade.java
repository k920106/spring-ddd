package com.spring.www.application.order;

import com.spring.www.domain.order.Order;
import com.spring.www.domain.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderFacade {
    private final OrderService orderService;

    public Order createOrder(Order order) {
        return orderService.createOrder(order);
    }
}
