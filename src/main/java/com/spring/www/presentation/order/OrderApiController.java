package com.spring.www.presentation.order;

import com.spring.www.presentation.config.advice.ApiResponseWrap;
import com.spring.www.application.order.OrderFacade;
import com.spring.www.application.order.command.OrderCreateCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/orders")
@RestController
public class OrderApiController {
    private final OrderFacade orderFacade;

    @ApiResponseWrap
    @PostMapping("/create")
    public OrderCreateResponse createOrder(@RequestBody OrderCreateRequest orderCreateRequest) {
        OrderCreateCommand command = orderCreateRequest.from();
        Long orderId = orderFacade.createOrder(command);
        return OrderCreateResponse.of(orderId);
    }

    // 예시
    // 럭키박스 주문
    @ApiResponseWrap
    @PostMapping("/create/luckybox")
    public OrderCreateResponse createOrderLuckyBox(@RequestBody OrderCreateOtherRequest orderCreateOtherRequest) {
        OrderCreateCommand command = orderCreateOtherRequest.from();
        Long orderId = orderFacade.createOrder(command);
        return OrderCreateResponse.of(orderId);
    }
}
