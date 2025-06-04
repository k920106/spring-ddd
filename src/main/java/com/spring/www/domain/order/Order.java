package com.spring.www.domain.order;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Order {
    private Long id;
    private String odrStusCd;
    private String odrerId;
    private OrderUser orderUser;
    private String cpId;
    private Long evtNo;
    private Long evtPtnNo;
    private Long dcCpnUseNo;
    private String payMtdCd;
    private Integer totPayAmt;
    private Integer dcAmt;
    private Integer usePoint;
    private String odrTypeCd;
    private String odrDd;
    private LocalDateTime odrDt;
    private String cncMemo;
    private LocalDateTime cncDt;
    private String delYn;

    public void cancel(String cancelMemo) {
        if ("CANCEL".equals(this.odrStusCd)) {
            throw new IllegalStateException("이미 취소된 주문입니다.");
        }

        this.odrStusCd = "CANCEL";
        this.cncMemo = cancelMemo;
        this.cncDt = LocalDateTime.now();
    }

    private Order(Long id, String odrStusCd, String odrerId, OrderUser orderUser, String cpId, Long evtNo, Long evtPtnNo, Long dcCpnUseNo, String payMtdCd, Integer totPayAmt, Integer dcAmt, Integer usePoint, String odrTypeCd, String odrDd, LocalDateTime odrDt, String cncMemo, LocalDateTime cncDt, String delYn) {
        this.id = id;
        this.odrStusCd = odrStusCd;
        this.odrerId = odrerId;
        this.orderUser = orderUser;
        this.cpId = cpId;
        this.evtNo = evtNo;
        this.evtPtnNo = evtPtnNo;
        this.dcCpnUseNo = dcCpnUseNo;
        this.payMtdCd = payMtdCd;
        this.totPayAmt = totPayAmt;
        this.dcAmt = dcAmt;
        this.usePoint = usePoint;
        this.odrTypeCd = odrTypeCd;
        this.odrDd = odrDd;
        this.odrDt = odrDt;
        this.cncMemo = cncMemo;
        this.cncDt = cncDt;
        this.delYn = delYn;
    }

    public static Order of(
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
        return new Order(
            id,
            odrStusCd,
            odrerId,
            orderUser,
            cpId,
            evtNo,
            evtPtnNo,
            dcCpnUseNo,
            payMtdCd,
            totPayAmt,
            dcAmt,
            usePoint,
            odrTypeCd,
            odrDd,
            odrDt,
            cncMemo,
            cncDt,
            delYn
        );
    }
}
