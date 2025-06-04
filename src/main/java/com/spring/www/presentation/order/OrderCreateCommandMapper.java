package com.spring.www.presentation.order;

import com.spring.www.application.order.command.OrderCreateCommand;
import com.spring.www.domain.order.OrderUser;
import org.springframework.stereotype.Component;

/**
 * 방법 1
 */
@Component
public class OrderCreateCommandMapper {
    public OrderCreateCommand from(OrderCreateRequest orderCreateRequest) {
        OrderUser orderUser = OrderUser.of(orderCreateRequest.odrerNm(), orderCreateRequest.odrerTelNo());

        return OrderCreateCommand.builder()
//            .odrStusCd(orderCreateRequest.odrStusCd())
            .odrerId(orderCreateRequest.odrerId())
            .orderUser(orderUser)
            .cpId(orderCreateRequest.cpId())
            .evtNo(orderCreateRequest.evtNo())
            .evtPtnNo(orderCreateRequest.evtPtnNo())
            .dcCpnUseNo(orderCreateRequest.dcCpnUseNo())
            .payMtdCd(orderCreateRequest.payMtdCd())
            .totPayAmt(orderCreateRequest.totPayAmt())
            .dcAmt(orderCreateRequest.dcAmt())
            .usePoint(orderCreateRequest.usePoint())
            .odrTypeCd(orderCreateRequest.odrTypeCd())
//            .odrDd(orderCreateRequest.odrDd())
//            .cncMemo(orderCreateRequest.cncMemo())
//            .delYn(orderCreateRequest.delYn())
            .build();
    }

    public OrderCreateCommand from(OrderCreateOtherRequest orderCreateOtherRequest) {
        String orderNm = orderCreateOtherRequest.odrerNm() + "(" + orderCreateOtherRequest.promotionName() + ")";
        OrderUser orderUser = OrderUser.of(orderNm, orderCreateOtherRequest.odrerTelNo());

        return OrderCreateCommand.builder()
            .odrStusCd(orderCreateOtherRequest.odrStusCd())
            .odrerId(orderCreateOtherRequest.odrerId())
            .orderUser(orderUser)
            .cpId(orderCreateOtherRequest.cpId())
            .evtNo(orderCreateOtherRequest.evtNo())
            .evtPtnNo(orderCreateOtherRequest.evtPtnNo())
            .dcCpnUseNo(orderCreateOtherRequest.dcCpnUseNo())
            .payMtdCd(orderCreateOtherRequest.payMtdCd())
            .totPayAmt(orderCreateOtherRequest.totPayAmt())
            .dcAmt(orderCreateOtherRequest.dcAmt())
            .usePoint(orderCreateOtherRequest.usePoint())
            .odrTypeCd(orderCreateOtherRequest.odrTypeCd())
//            .odrDd(orderCreateOtherRequest.odrDd())
//            .cncMemo(orderCreateOtherRequest.cncMemo())
//            .delYn(orderCreateOtherRequest.delYn())
            .build();
    }
}
