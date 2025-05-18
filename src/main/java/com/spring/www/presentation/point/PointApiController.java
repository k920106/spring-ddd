package com.spring.www.presentation.point;

import com.spring.www.application.point.PointFacade;
import com.spring.www.application.point.command.balance.PointBalanceCommandMapper;
import com.spring.www.application.point.command.use.PointUseCommand;
import com.spring.www.application.point.command.use.PointUseCommandMapper;
import com.spring.www.application.point.command.balance.PointBalanceCommand;
import com.spring.www.presentation.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/points")
@RestController
public class PointApiController {
    private final PointFacade pointFacade;
    private final PointBalanceCommandMapper pointBalanceCommandMapper;
    private final PointUseCommandMapper pointUseCommandMapper;

    @GetMapping("/balance")
    public ResponseEntity<CommonResponse<PointBalanceResponse>> balancePoint(
            @RequestBody PointBalanceRequest pointBalanceRequest
    ) {
        PointBalanceCommand command = pointBalanceCommandMapper.from(pointBalanceRequest);
        Long point = pointFacade.balance(command);
        return ResponseEntity.ok(new CommonResponse<>(new PointBalanceResponse(point)));
    }

    @PostMapping("/use")
    public ResponseEntity<CommonResponse<PointUseResponse>> usePoint(
            @RequestBody PointUseRequest pointUseRequest
    ) {
        PointUseCommand command = pointUseCommandMapper.from(pointUseRequest);
        pointFacade.use(command);
        return ResponseEntity.ok(new CommonResponse<>(new PointUseResponse("a")));
    }
}
