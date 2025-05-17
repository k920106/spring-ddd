package com.spring.www.domain.payment;

import com.spring.www.domain.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final OrderService orderService;

    public Payment createPayment(Payment payment) {
        // 결제 유효성 검증
//        validateCreatePayment(payment);

        // 주문 정보
        orderService.findById(payment.orderId());

        return paymentRepository.save(payment);
    }
}
