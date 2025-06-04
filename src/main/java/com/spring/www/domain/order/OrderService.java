package com.spring.www.domain.order;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order findById(Long id) {
        return orderRepository.findById(id);
    }

    public void cancel(Long id) {
        Order findOrder = findById(id);
        findOrder.cancel("취소염");
        orderRepository.save(findOrder);
    }
}
