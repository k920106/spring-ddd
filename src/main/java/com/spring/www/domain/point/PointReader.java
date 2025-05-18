package com.spring.www.domain.point;

import com.spring.www.application.point.command.balance.PointBalanceCommand;

public interface PointReader {
    Long balance(PointBalanceCommand command);
    Long use();
}
