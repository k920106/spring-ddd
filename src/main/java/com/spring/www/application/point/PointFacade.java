package com.spring.www.application.point;

import com.spring.www.application.point.command.use.PointUseCommand;
import com.spring.www.domain.payment.PaymentService;
import com.spring.www.domain.point.PointService;
import com.spring.www.domain.user.User;
import com.spring.www.domain.user.UserService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

/**
 * 퍼사드 (Facade)
 * 복잡한 시스템에 대해 단순화된 인터페이스를 제공합니다
 */
@RequiredArgsConstructor
@Service
public class PointFacade {
    private final PointService pointService;
    private final PaymentService paymentService;
    private final UserService userService;

    public Long balance() {
        User user = userService.getUser("aptner");
        return pointService.balance(user);
    }

    public void use(PointUseCommand command) {
        // 기존 포인트 조회
        // 결제 성공을 호출해야된다
//        pointService.use(command);
        paymentService.updatePayment();
    }
}
