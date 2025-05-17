package com.spring.www.infrastructure.persistence.payment;

import com.spring.www.domain.payment.Payment;
import com.spring.www.infrastructure.persistence.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class PaymentEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ORDER_ID", nullable = false)
    private Long orderId;

    @Enumerated(EnumType.STRING)
    @Column(name = "PAYMENT_STATUS", nullable = false)
    private PaymentStatus paymentStatus; // 결제 상태

    @Enumerated(EnumType.STRING)
    @Column(name = "PAYMENT_METHOD", nullable = false)
    private PaymentMethod paymentMethod; // 결제 수단 (예: CARD, POINT 등)

    @Column(name = "AMOUNT", nullable = false)
    private Long amount; // 결제 금액

    @Column(name = "PAID_AT")
    private LocalDateTime paidAt; // 결제 완료 시간

    @Column(name = "CANCELED_AT")
    private LocalDateTime canceledAt; // 결제 취소 시간

    private PaymentEntity(Long id, Long orderId, PaymentStatus paymentStatus, PaymentMethod paymentMethod, Long amount, LocalDateTime paidAt, LocalDateTime canceledAt) {
        this.id = id;
        this.orderId = orderId;
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.paidAt = paidAt;
        this.canceledAt = canceledAt;
    }

    public static PaymentEntity from(Payment payment) {
        return new PaymentEntity(
                null,
                payment.orderId(),
                payment.paymentStatus(),
                payment.paymentMethod(),
                payment.amount(),
                null,
                null
        );
    }
}
