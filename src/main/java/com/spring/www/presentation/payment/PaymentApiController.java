package com.spring.www.presentation.payment;

import com.spring.www.presentation.config.advice.ApiResponseWrap;
import com.spring.www.application.payment.PaymentFacade;
import com.spring.www.application.payment.command.PaymentConfirmCommandMapper;
import com.spring.www.application.payment.command.PaymentCreateCommand;
import com.spring.www.application.payment.command.PaymentCreateCommandMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/payments")
@RestController
public class PaymentApiController {
    private final PaymentFacade paymentFacade;
    private final PaymentCreateCommandMapper paymentCreateCommandMapper;
    private final PaymentConfirmCommandMapper paymentConfirmCommandMapper;

    @ApiResponseWrap
    @PostMapping("/create")
    public PaymentCreateResponse createPayment(@RequestBody PaymentCreateRequest paymentCreateRequest) {
        PaymentCreateCommand command = paymentCreateCommandMapper.from(paymentCreateRequest);
        Long paymentId = paymentFacade.createPayment(command);
        return PaymentCreateResponse.of(paymentId);
    }

    // 포인트 결제
    @ApiResponseWrap
    @PutMapping("/confirm")
    public PaymentConfirmResponse ConfirmPayment(@RequestBody PaymentConfirmRequest paymentConfirmRequest) {
        paymentConfirmCommandMapper.from(paymentConfirmRequest);
        return PaymentConfirmResponse.of();
    }

    // PG
//    @PatchMapping("/complete")
//    public ResponseEntity<CommonResponse<PaymentConfirmResponse>> CompletePayment(@RequestBody PaymentConfirmRequest paymentConfirmRequest) {
//        return ResponseEntity.ok(new CommonResponse<>(new PaymentConfirmResponse()));
//    }

    /**
     * PG 결제 "승인" 또는 "확정"
     *  @PutMapping("/confirm")
     *
     * PG 결제 "완료" 후 호출됨
     *  @PutMapping("/complete")
     *
     * PG에서 서버로 콜백하는 경우 (보통 Webhook용).
     *  @PutMapping("/callback")
     *
     * 결제를 "최종 확정"
     *  @PutMapping("/finalize")
     *
     */
}
