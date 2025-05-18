package com.spring.www.application.point.factory;

import com.spring.www.application.point.command.balance.*;
import org.springframework.stereotype.Component;

/**
 * 팩토리 메서드 (Factory Method)
 * 객체 생성을 서브 클래스에서 결정하도록 하여, 객체 생성 로직을 캡슐화합니다.
 */
@Component
public class PointBalanceFactory {
    public PointBalanceCommand from(String companyCode, String ci, String accessToken) {
        return switch (companyCode.toLowerCase()) {
            // lg -> default
            case "skt" -> SktPointBalanceCommand.from(ci);
            case "kt" -> ktPointBalanceCommand.builder().accessToken(accessToken).build();
            case "ibk" -> IbkPointBalanceCommand.builder().ci(ci).build();
            case "aptner" -> AptnerPointBalanceCommand.builder().ci(ci).build();
            default -> BasePointBalanceCommand.builder().accessToken(accessToken).build();
        };
    }
}
