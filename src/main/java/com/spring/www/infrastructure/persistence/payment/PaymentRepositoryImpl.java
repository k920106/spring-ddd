package com.spring.www.infrastructure.persistence.payment;

import com.spring.www.domain.payment.Payment;
import com.spring.www.domain.payment.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class PaymentRepositoryImpl implements PaymentRepository {
    private final PaymentJpaRepository paymentJpaRepository;

    @Override
    public Payment save(Payment payment) {
        PaymentEntity savedEntity = paymentJpaRepository.save(PaymentEntity.from(payment));
        return Payment.builder()
                      .id(savedEntity.getId())
                      .orderId(savedEntity.getOrderId())
                      .paymentStatus(savedEntity.getPaymentStatus())
                      .paymentMethod(savedEntity.getPaymentMethod())
                      .amount(savedEntity.getAmount())
                      .paidAt(savedEntity.getPaidAt())
                      .canceledAt(savedEntity.getCanceledAt())
                      .build();
    }
}
