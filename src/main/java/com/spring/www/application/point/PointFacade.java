package com.spring.www.application.point;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.www.application.point.command.PointUseCommand;
import com.spring.www.domain.point.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PointFacade {
    private final PointService pointService;
    private final ObjectMapper objectMapper;

    public Long balance() {
        return pointService.balance();
    }

    public void Point(PointUseCommand pointUseCommand) {
        Point point
        return pointService.use();
    }
}
