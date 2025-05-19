package com.spring.www.application.order.command;

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
