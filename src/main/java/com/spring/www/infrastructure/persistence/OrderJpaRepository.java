package com.spring.www.infrastructure.persistence.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<com.spring.www.infrastructure.persistence.order.OrderEntity, Long> {
}
