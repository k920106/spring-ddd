package com.spring.www.domain.order;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record OrderCreate(
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
) implements Order {
    public OrderCreate {
        if (cncMemo == null || cncMemo.isBlank()) {
            throw new IllegalArgumentException("cncMemo 값은 필수입니다.");
        }

        if (cncMemo.length() < 4) {
            throw new IllegalArgumentException("cncMemo 값은 4자 이상이어야 합니다.");
        }
    }

    public String getOrderUserNm() {
        return orderUser.odrerNm();
    }

    public static OrderCreate of(
        Long id,
        String odrStusCd,
        String odrerId,
        String odrerNm,
        String odrerTelNo,
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
        return builder().id(id)
                        .odrStusCd(odrStusCd)
                        .odrerId(odrerId)
                        .orderUser(OrderUser.of(odrerNm, odrerTelNo))
                        .cpId(cpId)
                        .evtNo(evtNo)
                        .evtPtnNo(evtPtnNo)
                        .dcCpnUseNo(dcCpnUseNo)
                        .payMtdCd(payMtdCd)
                        .totPayAmt(totPayAmt)
                        .dcAmt(dcAmt)
                        .usePoint(usePoint)
                        .odrTypeCd(odrTypeCd)
                        .odrDd(odrDd)
                        .odrDt(odrDt)
                        .cncMemo(cncMemo)
                        .cncDt(cncDt)
                        .delYn(delYn)
                        .build();
    }

    @Override
    public Long getId() {
        return id;
    }
}
