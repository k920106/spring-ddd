package com.spring.www.presentation.thirdparty;

import com.spring.www.presentation.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/third-party")
@RestController
public class ThirdPartyApiController {
    @PostMapping("/points/balance")
    public ResponseEntity<CommonResponse<ThirdPartyPointBalanceResponse>> balancePoint(
            @RequestBody ThirdPartyPointBalanceRequest thirdPartyPointBalanceRequest
    ) {
        log.info("base");
        log.info("thirdPartyPointBalanceRequest: {}", thirdPartyPointBalanceRequest);
        log.info("=====");
        return ResponseEntity.ok(new CommonResponse<>(new ThirdPartyPointBalanceResponse(1000L)));
    }

    @PostMapping("/points/balance/skt")
    public ResponseEntity<CommonResponse<ThirdPartyPointBalanceResponse>> balancePointSkt(
            @RequestBody ThirdPartyPointBalanceSktRequest thirdPartyPointBalanceSktRequest
    ) {
        log.info("skt");
        log.info("thirdPartyPointBalanceSktRequest: {}", thirdPartyPointBalanceSktRequest);
        log.info("=====");
        return ResponseEntity.ok(new CommonResponse<>(new ThirdPartyPointBalanceResponse(2000L)));
    }

    @GetMapping("/points/balance/kt")
    public ResponseEntity<CommonResponse<ThirdPartyPointBalanceResponse>> balancePointKt(
            @RequestHeader("Authorization") String accessToken
    ) {
        log.info("kt");
        log.info("Header Authorization: {}", accessToken);
        log.info("=====");
        return ResponseEntity.ok(new CommonResponse<>(new ThirdPartyPointBalanceResponse(3000L)));
    }

    @GetMapping("/points/balance/ibk")
    public ResponseEntity<CommonResponse<ThirdPartyPointBalanceResponse>> balancePointIbk(
            @RequestHeader("ci") String ci
    ) {
        log.info("ibk");
        log.info("Header ci: {}", ci);
        log.info("=====");
        return ResponseEntity.ok(new CommonResponse<>(new ThirdPartyPointBalanceResponse(4000L)));
    }

    @GetMapping("/points/balance/aptner")
    public ResponseEntity<CommonResponse<ThirdPartyPointBalanceResponse>> balancePointAptner(
            @RequestParam("ci") String ci
    ) {
        log.info("aptner");
        log.info("ci: {}", ci);
        log.info("=====");
        return ResponseEntity.ok(new CommonResponse<>(new ThirdPartyPointBalanceResponse(5000L)));
    }
}
