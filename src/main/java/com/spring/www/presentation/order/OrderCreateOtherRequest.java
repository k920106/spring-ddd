package com.spring.www.presentation.order;

import jakarta.validation.constraints.Size;

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
        @Size(min = 4, message = "cncMemo는 4자 이상이어야 합니다.")
        String cncMemo,
        String delYn,
        String promotionName
) {
}
