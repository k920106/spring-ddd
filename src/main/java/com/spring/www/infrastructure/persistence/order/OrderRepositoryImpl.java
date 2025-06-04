package com.spring.www.infrastructure.persistence.order;

import com.spring.www.domain.order.Order;
import com.spring.www.domain.order.OrderUser;
import com.spring.www.domain.order.OrderRepository;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderJpaRepository orderJpaRepository;

    @Override
    public Order save(Order order) {
        OrderEntity savedEntity = orderJpaRepository.save(OrderEntity.from(order));

        return Order.of(
            savedEntity.getId(),
            savedEntity.getOdrStusCd(),
            savedEntity.getOdrerId(),
            OrderUser.of(savedEntity.getOdrerNm(), savedEntity.getOdrerTelNo()),
            savedEntity.getCpId(),
            savedEntity.getEvtNo(),
            savedEntity.getEvtPtnNo(),
            savedEntity.getDcCpnUseNo(),
            savedEntity.getPayMtdCd(),
            savedEntity.getTotPayAmt(),
            savedEntity.getDcAmt(),
            savedEntity.getUsePoint(),
            savedEntity.getOdrTypeCd(),
            savedEntity.getOdrDd(),
            savedEntity.getOdrDt(),
            savedEntity.getCncMemo(),
            savedEntity.getCncDt(),
            savedEntity.getDelYn()
        );
    }

    @Override
    public Order findById(Long id) {
        OrderEntity findEntity = orderJpaRepository.findById(id).orElseThrow(() -> new OrderException(OrderExceptionResult.NOT_FOUND_ORDER));

        return Order.of(
            findEntity.getId(),
            findEntity.getOdrStusCd(),
            findEntity.getOdrerId(),
            OrderUser.of(findEntity.getOdrerNm(), findEntity.getOdrerTelNo()),
            findEntity.getCpId(),
            findEntity.getEvtNo(),
            findEntity.getEvtPtnNo(),
            findEntity.getDcCpnUseNo(),
            findEntity.getPayMtdCd(),
            findEntity.getTotPayAmt(),
            findEntity.getDcAmt(),
            findEntity.getUsePoint(),
            findEntity.getOdrTypeCd(),
            findEntity.getOdrDd(),
            findEntity.getOdrDt(),
            findEntity.getCncMemo(),
            findEntity.getCncDt(),
            findEntity.getDelYn()
        );
    }
}
