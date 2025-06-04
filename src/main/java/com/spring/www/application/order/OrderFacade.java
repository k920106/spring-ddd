package com.spring.www.application.order;

import com.spring.www.application.order.command.OrderCreateCommand;
import com.spring.www.domain.order.Order;
import com.spring.www.domain.order.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderFacade {
    private final OrderService orderService;

    @Transactional
    public Long createOrder(OrderCreateCommand command) {
        // 주문 생성
        Order savedOrder = orderService.createOrder(command.toOrder());
        return savedOrder.getId();
    }

    @Transactional
    public void cancelOrder(Long id) {
        orderService.cancel(id);
    }
}
