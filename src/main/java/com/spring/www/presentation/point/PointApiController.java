package com.spring.www.presentation.point;

import com.spring.www.presentation.config.advice.ApiResponseWrap;
import com.spring.www.application.point.PointFacade;
import com.spring.www.application.point.command.balance.PointBalanceCommand;
import com.spring.www.application.point.command.balance.PointBalanceCommandMapper;
import com.spring.www.application.point.command.use.PointUseCommand;
import com.spring.www.application.point.command.use.PointUseCommandMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/points")
@RestController
public class PointApiController {
    private final PointFacade pointFacade;
    private final PointBalanceCommandMapper pointBalanceCommandMapper;
    private final PointUseCommandMapper pointUseCommandMapper;

    @ApiResponseWrap
    @GetMapping("/balance")
    public PointBalanceResponse balancePoint(
            @RequestBody PointBalanceRequest pointBalanceRequest
    ) {
        PointBalanceCommand command = pointBalanceCommandMapper.from(pointBalanceRequest);
        Long point = pointFacade.balance(command);
        return PointBalanceResponse.of(point);
    }

    @ApiResponseWrap
    @PostMapping("/use")
    public PointUseResponse usePoint(
            @RequestBody PointUseRequest pointUseRequest
    ) {
        PointUseCommand command = pointUseCommandMapper.from(pointUseRequest);
        pointFacade.use(command);
        return PointUseResponse.of("a");
    }
}
