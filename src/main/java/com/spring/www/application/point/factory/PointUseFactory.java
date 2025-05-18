package com.spring.www.application.point.factory;

import com.spring.www.application.point.command.balance.*;
import com.spring.www.application.point.command.use.PointUseCommand;
import com.spring.www.presentation.point.PointUseRequest;
import org.springframework.stereotype.Component;

@Component
public class PointUseFactory {
    public PointUseCommand from(String companyCode, String accessToken, String ci, Long pointUse, String wkbPaymentNo) {
        return null;
//        return switch (companyCode.toLowerCase()) {
//            // lg -> default
//            case "skt" -> SktPointBalanceCommand.builder().ci(ci).build();
//            case "kt" -> ktPointBalanceCommand.builder().accessToken(accessToken).build();
//            case "ibk" -> IbkPointBalanceCommand.builder().ci(ci).build();
//            case "aptner" -> AptnerPointBalanceCommand.builder().ci(ci).build();
//            default -> BasePointBalanceCommand.builder().accessToken(accessToken).build();
//        };
    }
}
