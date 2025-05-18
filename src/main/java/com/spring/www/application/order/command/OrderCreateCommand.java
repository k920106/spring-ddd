package com.spring.www.application.order.command;

import com.spring.www.presentation.order.OrderCreateOtherRequest;
import com.spring.www.presentation.order.OrderCreateRequest;
import com.spring.www.domain.order.OrderCreate;
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
        String odrTypeCd,
        String odrDd,
        LocalDateTime odrDt,
        String cncMemo,
        LocalDateTime cncDt,
        String delYn
) {
    public static OrderCreateCommand from(OrderCreateRequest orderCreateRequest) {
        OrderUser orderUser = OrderUser.of(orderCreateRequest.odrerNm(), orderCreateRequest.odrerTelNo());

        return OrderCreateCommand.builder()
                                 .odrStusCd(orderCreateRequest.odrStusCd())
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
                                 .odrDd(orderCreateRequest.odrDd())
                                 .cncMemo(orderCreateRequest.cncMemo())
                                 .delYn(orderCreateRequest.delYn())
                                 .build();

    }

    public static OrderCreateCommand from(OrderCreateOtherRequest orderCreateOtherRequest) {
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
                                 .odrDd(orderCreateOtherRequest.odrDd())
                                 .cncMemo(orderCreateOtherRequest.cncMemo())
                                 .delYn(orderCreateOtherRequest.delYn())
                                 .build();
    }

    public OrderCreate toOrder() {
        return OrderCreate.builder()
                    .odrStusCd(this.odrStusCd())
                    .odrerId(this.odrerId())
                    .orderUser(this.orderUser())
                    .cpId(this.cpId())
                    .evtNo(this.evtNo())
                    .evtPtnNo(this.evtPtnNo())
                    .dcCpnUseNo(this.dcCpnUseNo())
                    .payMtdCd(this.payMtdCd())
                    .totPayAmt(this.totPayAmt())
                    .dcAmt(this.dcAmt())
                    .usePoint(this.usePoint())
                    .odrTypeCd(this.odrTypeCd())
                    .odrDd(this.odrDd())
                    .odrDt(this.odrDt() != null ? this.odrDt() : LocalDateTime.now())
                    .cncMemo(this.cncMemo())
                    .cncDt(this.cncDt())
                    .delYn(this.delYn())
                    .build();
    }
}
