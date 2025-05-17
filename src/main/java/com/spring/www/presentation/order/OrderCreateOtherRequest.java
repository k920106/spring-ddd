package com.spring.www.presentation.order;

import java.util.List;

public record OrderCreateOtherRequest(
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
        String cncMemo,
        String delYn,
        String promotionName
) {
}
