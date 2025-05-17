package com.spring.www.infrastructure.persistence.payment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentJpaRepository extends JpaRepository<PaymentEntity, Long> {
}
