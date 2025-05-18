package com.spring.www.application.point.command.balance;

import com.spring.www.infrastructure.persistence.point.ExternalPointReader;
import lombok.Builder;

@Builder
public record ktPointBalanceCommand(String accessToken) implements PointBalanceCommand {
    @Override
    public Long process(ExternalPointReader reader) {
        return reader.processKtPointBalance(this);
    }
}
