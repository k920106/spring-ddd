package com.spring.www.application.point.command.use;

import com.spring.www.application.point.factory.PointUseFactory;
import com.spring.www.presentation.point.PointUseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PointUseCommandMapper {
    private final PointUseFactory pointUseFactory;

    public PointUseCommand from(PointUseRequest pointUseRequest) {
//        return pointUseFactory.from(pointUseRequest.accessToken(), pointUseRequest.ci(), pointUseRequest.pointUse(), pointUseRequest.wkbPaymentNo());
        return null;
    }
}
