package com.spring.www.application.point.command;

import com.spring.www.presentation.point.PointUseRequest;
import org.springframework.stereotype.Component;

@Component
public class PointUseCommandMapper {
    public PointUseCommand from(PointUseRequest pointUseRequest) {
        return PointUseCommand.builder()
                              .accessToken(pointUseRequest.accessToken())
                              .wkbPaymentNo(pointUseRequest.wkbPaymentNo())
                              .pointUse(pointUseRequest.pointUse())
                              .build();
    }
}
