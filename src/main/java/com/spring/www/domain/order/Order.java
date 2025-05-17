package com.spring.www.domain.order;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record Order(
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

}
