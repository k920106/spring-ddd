package com.spring.www.application.order.command;

import com.spring.www.domain.order.Order;
import com.spring.www.domain.order.OrderUser;
import lombok.Builder;

import java.time.LocalDateTime;

/**
 * 방법 2
 */
@Builder
public record OrderCreateCommand(
    Long id,
    String odrStusCd,
    String odrerId,
    OrderUser orderUser,
    String cpId,
    Long evtNo,
    Long evtPtnNo,
    Long dcCpnUseNo,
    String payMtdCd,
    Integer totPayAmt,
    Integer dcAmt,
    Integer usePoint,
    String odrTypeCd
) {
    public Order toOrder() {
        return Order.of(
            id,
            "READY",
            odrerId,
            orderUser,
            cpId,
            evtNo,
            evtPtnNo,
            dcCpnUseNo,
            payMtdCd,
            totPayAmt,
            dcAmt,
            usePoint,
            odrTypeCd,
            "20260101",
            LocalDateTime.now(),
            "",
            null,
            "N"
        );
    }
}
