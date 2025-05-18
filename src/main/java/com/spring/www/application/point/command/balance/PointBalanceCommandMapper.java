package com.spring.www.application.point.command.balance;

import com.spring.www.application.point.factory.PointBalanceFactory;
import com.spring.www.presentation.point.PointBalanceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PointBalanceCommandMapper {
    private final PointBalanceFactory pointBalanceFactory;

    public PointBalanceCommand from(PointBalanceRequest pointBalanceRequest) {
        return pointBalanceFactory.from(pointBalanceRequest.companyCode(), pointBalanceRequest.ci(), pointBalanceRequest.accessToken());
    }
}
