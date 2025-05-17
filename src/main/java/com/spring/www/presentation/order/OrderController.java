package com.spring.www.presentation.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.www.application.order.OrderFacade;
import com.spring.www.domain.order.Order;
import com.spring.www.presentation.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/orders")
@RestController
public class OrderController {
    private final OrderFacade orderFacade;
    private final ObjectMapper objectMapper;

    @PostMapping("/create")
    public ResponseEntity<CommonResponse<OrderCreateResponse>> createOrder(@RequestBody OrderCreateRequest orderCreateRequest) {
        Order order = objectMapper.convertValue(orderCreateRequest, Order.class);
        Order savedOrder = orderFacade.createOrder(order);
        return ResponseEntity.ok(new CommonResponse<>(new OrderCreateResponse(savedOrder)));
    }
}
