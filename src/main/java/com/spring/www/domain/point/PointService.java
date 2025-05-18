package com.spring.www.domain.point;

import com.spring.www.application.point.command.balance.PointBalanceCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PointService {
    private final PointReader pointReader;

    public Long balance(PointBalanceCommand command) {
        return pointReader.balance(command);
    }

    public Long use() {
        return pointReader.use();
    }
}
