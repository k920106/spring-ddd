package com.spring.www.domain.order;

public interface OrderRepository {
    Order save(Order order);
    Order findById(Long id);
}
