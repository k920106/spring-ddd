package com.spring.www.infrastructure.persistence.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.www.domain.order.Order;
import com.spring.www.domain.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private final com.spring.www.infrastructure.persistence.order.OrderJpaRepository orderJpaRepository;
    private final ObjectMapper objectMapper;

    @Override
    public Order save(Order order) {
        com.spring.www.infrastructure.persistence.order.OrderEntity savedEntity = orderJpaRepository.save(com.spring.www.infrastructure.persistence.order.OrderEntity.from(order));
//        return objectMapper.convertValue(savedEntity, Order.class);
        return Order.builder()
                    .id(savedEntity.getId())
                    .odrStusCd(savedEntity.getOdrStusCd())
                    .odrerId(savedEntity.getOdrerId())
                    .odrerNm(savedEntity.getOdrerNm())
                    .odrerTelNo(savedEntity.getOdrerTelNo())
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
}
