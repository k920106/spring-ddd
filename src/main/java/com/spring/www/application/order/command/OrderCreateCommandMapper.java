package com.spring.www.application.order.command;

import com.spring.www.domain.order.OrderUser;
import com.spring.www.presentation.order.OrderCreateOtherRequest;
import com.spring.www.presentation.order.OrderCreateRequest;
import org.springframework.stereotype.Component;

/**
 * objectMapper를 사용할 경우 OrderCreateCommand 스펙이 변경될 경우 대응이 어려워짐
 * 예를 들면 orderNm(주문자명), orderTelNo(주문자 휴대폰번호)가 OrderAccount class로 생성되는 경우 objectMapper는 String형으로 되어 있는 문제
 */
@Component
public class OrderCreateCommandMapper {
        public OrderCreateCommand from(OrderCreateRequest orderCreateRequest) {
                OrderUser orderUser = OrderUser.builder()
                                               .odrerNm(orderCreateRequest.odrerNm())
                                               .odrerTelNo(orderCreateRequest.odrerTelNo())
                                               .build();

                return OrderCreateCommand.builder()
                                         .odrStusCd(orderCreateRequest.odrStusCd())
                                         .odrerId(orderCreateRequest.odrerId())
//                                         .odrerNm(orderCreateRequest.odrerNm())
//                                         .odrerTelNo(orderCreateRequest.odrerTelNo())
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

        public OrderCreateCommand from(OrderCreateOtherRequest orderCreateOtherRequest) {
                String orderNm = orderCreateOtherRequest.odrerNm() + "(" + orderCreateOtherRequest.promotionName() + ")";
                OrderUser orderUser = OrderUser.builder()
                                               .odrerNm(orderNm)
                                               .odrerTelNo(orderCreateOtherRequest.odrerTelNo())
                                               .build();

                return OrderCreateCommand.builder()
                                         .odrStusCd(orderCreateOtherRequest.odrStusCd())
                                         .odrerId(orderCreateOtherRequest.odrerId())
//                                         .odrerNm(orderNm)
//                                         .odrerTelNo(orderCreateOtherRequest.odrerTelNo())
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
}
