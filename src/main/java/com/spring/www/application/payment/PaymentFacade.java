package com.spring.www.application.payment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.www.application.payment.command.PaymentCreateCommand;
import com.spring.www.domain.payment.Payment;
import com.spring.www.domain.payment.PaymentService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class PaymentFacade {
    private final PaymentService paymentService;
    private final ObjectMapper objectMapper;
    private final Validator validator;

    @Transactional
    public Long createPayment(PaymentCreateCommand command) {
        Payment convertedPayment = objectMapper.convertValue(command, Payment.class);
        validateConvertedPayment(convertedPayment);
        Payment savedPayment = paymentService.createPayment(convertedPayment);
        return savedPayment.id();
    }

    @Transactional
    public Long confirmPayment(PaymentCreateCommand command) {
        Payment convertedPayment = objectMapper.convertValue(command, Payment.class);
        validateConvertedPayment(convertedPayment);
        return null;
    }

    private void validateConvertedPayment(Payment payment) {
        Set<ConstraintViolation<Payment>> violations = validator.validate(payment);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
