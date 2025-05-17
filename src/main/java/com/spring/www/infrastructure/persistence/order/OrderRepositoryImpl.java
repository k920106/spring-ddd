package com.spring.www.infrastructure.persistence.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.www.domain.order.Order;
import com.spring.www.domain.order.OrderRepository;
import com.spring.www.domain.order.OrderUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderJpaRepository orderJpaRepository;
    private final ObjectMapper objectMapper;

    @Override
    public Order save(Order order) {
        OrderEntity savedEntity = orderJpaRepository.save(OrderEntity.from(order));
        return Order.builder()
                    .id(savedEntity.getId())
                    .odrStusCd(savedEntity.getOdrStusCd())
                    .odrerId(savedEntity.getOdrerId())
                    // [상황] 주문자는 OrderUser 객체로 관리하기로 변경됨
//                    .odrerNm(savedEntity.getOdrerNm())
//                    .odrerTelNo(savedEntity.getOdrerTelNo())
                    .orderUser(OrderUser.builder()
                                        .odrerNm(savedEntity.getOdrerNm())
                                        .odrerTelNo(savedEntity.getOdrerTelNo())
                                        .build())
                    .cpId(savedEntity.getCpId())
                    .evtNo(savedEntity.getEvtNo())
                    .evtPtnNo(savedEntity.getEvtPtnNo())
                    .dcCpnUseNo(savedEntity.getDcCpnUseNo())
                    .payMtdCd(savedEntity.getPayMtdCd())
                    .totPayAmt(savedEntity.getTotPayAmt())
                    .dcAmt(savedEntity.getDcAmt())
                    .usePoint(savedEntity.getUsePoint())
                    .odrTypeCd(savedEntity.getOdrTypeCd())
                    .odrDd(savedEntity.getOdrDd())
                    .odrDt(savedEntity.getOdrDt())
                    .cncMemo(savedEntity.getCncMemo())
                    .cncDt(savedEntity.getCncDt())
                    .delYn(savedEntity.getDelYn())
                    .build();
    }

    @Override
    public Order findById(Long id) {
        OrderEntity findEntity = orderJpaRepository.findById(id).orElseThrow(() -> new OrderException(OrderExceptionResult.NOT_FOUND_ORDER));
        return objectMapper.convertValue(findEntity, Order.class);
    }
}
