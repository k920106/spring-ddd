package com.spring.www.domain.order;

public interface OrderRepository {
    Order save(OrderCreate order);
    Order findById(Long id);
}
