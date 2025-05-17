package com.spring.www.presentation.order;

public record OrderCreateRequest(
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
    String cncMemo,
    String delYn
) {
}
