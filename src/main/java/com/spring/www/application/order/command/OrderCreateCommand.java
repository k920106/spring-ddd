package com.spring.www.application.order.command;

import com.spring.www.domain.order.OrderUser;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record OrderCreateCommand(
        Long id,
        String odrStusCd,
        String odrerId,
        // [상황] 주문자는 OrderUser 객체로 관리하기로 변경됨
//        String odrerNm,
//        String odrerTelNo,
        OrderUser orderUser,
        String cpId,
        Long evtNo,
        Long evtPtnNo,
        Long dcCpnUseNo,
        String payMtdCd,
        Integer totPayAmt,
        Integer dcAmt,
        Integer usePoint,
        String odrTypeCd,
        String odrDd,
        LocalDateTime odrDt,
        String cncMemo,
        LocalDateTime cncDt,
        String delYn
) {
}
