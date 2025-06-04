package com.spring.www.infrastructure.persistence.order;

import com.spring.www.infrastructure.persistence.common.BaseEntity;
import com.spring.www.domain.order.Order;
import com.spring.www.domain.order.OrderUser;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class OrderEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ODR_STUS_CD", nullable = false, length = 10)
    private String odrStusCd;

    @Column(name = "ODRER_ID", nullable = false, length = 200)
    private String odrerId;

    @Column(name = "ODRER_NM", nullable = true, length = 100)
    private String odrerNm;

    @Column(name = "ODRER_TEL_NO", nullable = true, length = 40)
    private String odrerTelNo;

    @Column(name = "CP_ID", nullable = false, length = 100)
    private String cpId;

    @Column(name = "EVT_NO", nullable = true)
    private Long evtNo;

    @Column(name = "EVT_PTN_NO", nullable = true)
    private Long evtPtnNo;

    @Column(name = "DC_CPN_USE_NO", nullable = true)
    private Long dcCpnUseNo;

    @Column(name = "PAY_MTD_CD", nullable = false, length = 10)
    private String payMtdCd;

    @Column(name = "TOT_PAY_AMT", nullable = false)
    private Integer totPayAmt;

    @Column(name = "DC_AMT", nullable = false)
    private Integer dcAmt;

    @Column(name = "USE_POINT", nullable = false)
    private Integer usePoint;

    @Column(name = "ODR_TYPE_CD", nullable = false, length = 10)
    private String odrTypeCd;

    @Column(name = "ODR_DD", nullable = false, length = 8)
    private String odrDd;

    @Column(name = "ODR_DT", nullable = false)
    private LocalDateTime odrDt;

    @Column(name = "CNC_MEMO", nullable = true, length = 1000)
    private String cncMemo;

    @Column(name = "CNC_DT", nullable = true)
    private LocalDateTime cncDt;

    @Column(name = "DEL_YN", nullable = false, length = 1, columnDefinition = "char(1) default 'N'")
    private String delYn;

    private OrderEntity(Long id, String odrStusCd, String odrerId, String odrerNm, String odrerTelNo, String cpId, Long evtNo, Long evtPtnNo, Long dcCpnUseNo, String payMtdCd, Integer totPayAmt, Integer dcAmt, Integer usePoint, String odrTypeCd, String odrDd, LocalDateTime odrDt, String cncMemo, LocalDateTime cncDt, String delYn) {
        this.id = id;
        this.odrStusCd = odrStusCd;
        this.odrerId = odrerId;
        this.odrerNm = odrerNm;
        this.odrerTelNo = odrerTelNo;
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

    public static OrderEntity from(Order order) {
        OrderUser orderUser = order.getOrderUser();
        return new OrderEntity(
                order.getId(),
                order.getOdrStusCd(),
                order.getOdrerId(),
                orderUser.odrerNm(),
                orderUser.odrerTelNo(),
                order.getCpId(),
                order.getEvtNo(),
                order.getEvtPtnNo(),
                order.getDcCpnUseNo(),
                order.getPayMtdCd(),
                order.getTotPayAmt(),
                order.getDcAmt(),
                order.getUsePoint(),
                order.getOdrTypeCd(),
                order.getOdrDd(),
                order.getOdrDt(),
                order.getCncMemo(),
                order.getCncDt(),
                order.getDelYn()
        );
    }
}
