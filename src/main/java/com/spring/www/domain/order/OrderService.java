package com.spring.www.domain.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public Order createOrder(Order order) {
        // 주문 유효성 검증
//        validateCreateOrder(order);

        // 주문 저장
        return orderRepository.save(order);
    }

    public Order findById(Long id) {
        return orderRepository.findById(id);
    }
}
