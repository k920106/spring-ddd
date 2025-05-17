package com.spring.www.presentation.order;

import com.spring.www.application.order.command.OrderCreateCommandMapper;
import com.spring.www.application.order.OrderFacade;
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
public class OrderApiController {
    private final OrderFacade orderFacade;
//    private final ObjectMapper objectMapper;
    private final OrderCreateCommandMapper orderCreateCommandMapper;

    @PostMapping("/create")
    public ResponseEntity<CommonResponse<OrderCreateResponse>> createOrder(@RequestBody OrderCreateRequest orderCreateRequest) {
//        OrderCreateCommand convertedOrder = objectMapper.convertValue(orderCreateRequest, OrderCreateCommand.class);
        Long orderId = orderFacade.createOrder(orderCreateCommandMapper.from(orderCreateRequest));
        return ResponseEntity.ok(new CommonResponse<>(new OrderCreateResponse(orderId)));
    }

    // 예시
    // 프로모션 주문
    @PostMapping("/create/luckybox")
    public ResponseEntity<CommonResponse<OrderCreateResponse>> createOrderA(@RequestBody OrderCreateOtherRequest orderCreateOtherRequest) {
        Long orderId = orderFacade.createOrder(orderCreateCommandMapper.from(orderCreateOtherRequest));
        return ResponseEntity.ok(new CommonResponse<>(new OrderCreateResponse(orderId)));
    }
}
