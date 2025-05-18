package com.spring.www.application.point.command.balance;

import com.spring.www.infrastructure.persistence.point.ExternalPointReader;
import lombok.Builder;

@Builder
public record SktPointBalanceCommand(String ci) implements PointBalanceCommand {
    public static SktPointBalanceCommand from(String ci) {
        return builder().ci(ci).build();
    }


    @Override
    public Long process(ExternalPointReader reader) {
        return reader.processSktPointBalance(this);
    }
}
