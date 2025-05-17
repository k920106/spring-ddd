package com.spring.www.presentation.payment;

import com.spring.www.application.payment.PaymentFacade;
import com.spring.www.application.payment.command.PaymentConfirmCommandMapper;
import com.spring.www.application.payment.command.PaymentCreateCommandMapper;
import com.spring.www.presentation.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/payments")
@RestController
public class PaymentApiController {
    private final PaymentFacade paymentFacade;
    private final PaymentCreateCommandMapper paymentCreateCommandMapper;
    private final PaymentConfirmCommandMapper paymentConfirmCommandMapper;

    @PostMapping("/create")
    public ResponseEntity<CommonResponse<PaymentCreateResponse>> createPayment(@RequestBody PaymentCreateRequest paymentCreateRequest) {
        Long paymentId = paymentFacade.createPayment(paymentCreateCommandMapper.from(paymentCreateRequest));
        return ResponseEntity.ok(new CommonResponse<>(new PaymentCreateResponse(paymentId)));
    }

    // 포인트 결제
    @PutMapping("/confirm")
    public ResponseEntity<CommonResponse<PaymentConfirmResponse>> ConfirmPayment(@RequestBody PaymentConfirmRequest paymentConfirmRequest) {
        paymentConfirmCommandMapper.from(paymentConfirmRequest);
        return ResponseEntity.ok(new CommonResponse<>(new PaymentConfirmResponse()));
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
