package com.spring.www.application.point.command.balance;

import com.spring.www.infrastructure.persistence.point.ExternalPointReader;

public interface PointBalanceCommand {
    Long process(ExternalPointReader reader);
}
