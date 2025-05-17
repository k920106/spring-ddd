package com.spring.www.presentation.point;

import com.spring.www.application.point.PointFacade;
import com.spring.www.application.point.command.PointUseCommand;
import com.spring.www.application.point.command.PointUseCommandMapper;
import com.spring.www.presentation.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/points")
@RestController
public class PointApiController {
    private final PointFacade pointFacade;
    private final PointUseCommandMapper pointUseCommandMapper;

    @GetMapping("/balance")
    public ResponseEntity<CommonResponse<PointBalanceResponse>> balancePoint() {
        Long point = pointFacade.balance();
        return ResponseEntity.ok(new CommonResponse<>(new PointBalanceResponse(point)));
    }

    @PostMapping("/use")
    public ResponseEntity<CommonResponse<PointUseResponse>> usePoint(PointUseRequest pointUseRequest) {
        pointFacade.use(pointUseCommandMapper.from(pointUseRequest));
        return ResponseEntity.ok(new CommonResponse<>(new PointUseResponse(point)));
    }
}
