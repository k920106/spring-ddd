package com.spring.www.presentation.order;

import com.spring.www.application.order.command.OrderCreateCommand;
import com.spring.www.domain.order.OrderUser;
import jakarta.validation.constraints.Size;

import java.util.List;

public record OrderCreateRequest(
    String odrStusCd,
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
    String odrTypeCd,
    String odrDd,
    @Size(min = 4, message = "cncMemo는 4자 이상이어야 합니다.")
    String cncMemo,
    String delYn
) {
    public OrderCreateCommand from() {
        OrderUser orderUser = OrderUser.of(odrerNm(), odrerTelNo());

        return OrderCreateCommand.builder()
                                 .odrStusCd(odrStusCd())
                                 .odrerId(odrerId())
                                 .orderUser(orderUser)
                                 .cpId(cpId())
                                 .evtNo(evtNo())
                                 .evtPtnNo(evtPtnNo())
                                 .dcCpnUseNo(dcCpnUseNo())
                                 .payMtdCd(payMtdCd())
                                 .totPayAmt(totPayAmt())
                                 .dcAmt(dcAmt())
                                 .usePoint(usePoint())
                                 .odrTypeCd(odrTypeCd())
                                 .odrDd(odrDd())
                                 .cncMemo(cncMemo())
                                 .delYn(delYn())
                                 .build();
    }
}
