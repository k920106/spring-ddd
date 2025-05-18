package com.spring.www.domain.order;

import lombok.Builder;

@Builder
public record OrderUser(
    String odrerNm,
    String odrerTelNo
) {
    public OrderUser {
        if (odrerNm == null || odrerNm.isBlank()) {
            throw new IllegalArgumentException("odrerNm 값은 필수입니다.");
        }

        if (odrerTelNo == null || odrerTelNo.isBlank()) {
            throw new IllegalArgumentException("odrerTelNo 값은 필수입니다.");
        }
    }

    public static OrderUser of(String orderNm, String orderTelNo) {
        return builder().odrerNm(orderNm)
                        .odrerTelNo(orderTelNo)
                        .build();
    }
}
