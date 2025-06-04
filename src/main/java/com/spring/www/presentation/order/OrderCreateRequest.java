package com.spring.www.presentation.order;

import com.spring.www.application.order.command.OrderCreateCommand;
import com.spring.www.domain.order.OrderUser;

import java.util.List;

public record OrderCreateRequest(
    String odrerId,
    String odrerNm,
    String odrerTelNo,
    String cpId,
    List<Long> orderItems,
    Long evtNo,
    Long evtPtnNo,
    Long dcCpnUseNo,
    String payMtdCd,
    Integer totPayAmt,
    Integer dcAmt,
    Integer usePoint,
    String odrTypeCd
) {
    public OrderCreateCommand from() {
        return OrderCreateCommand.builder()
                                 .odrerId(odrerId())
                                 .orderUser(OrderUser.of(odrerNm(), odrerTelNo()))
                                 .cpId(cpId())
                                 .evtNo(evtNo())
                                 .evtPtnNo(evtPtnNo())
                                 .dcCpnUseNo(dcCpnUseNo())
                                 .payMtdCd(payMtdCd())
                                 .totPayAmt(totPayAmt())
                                 .dcAmt(dcAmt())
                                 .usePoint(usePoint())
                                 .odrTypeCd(odrTypeCd())
                                 .build();
    }
}
