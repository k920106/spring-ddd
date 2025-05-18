package com.spring.www.presentation.thirdparty;

import com.spring.www.presentation.config.advice.ApiResponseWrap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/third-party")
@RestController
public class ThirdPartyApiController {
    @ApiResponseWrap
    @PostMapping("/points/balance")
    public ThirdPartyPointBalanceResponse balancePoint(
            @RequestBody ThirdPartyPointBalanceRequest thirdPartyPointBalanceRequest
    ) {
        log.info("base");
        log.info("thirdPartyPointBalanceRequest: {}", thirdPartyPointBalanceRequest);
        log.info("=====");
        return new ThirdPartyPointBalanceResponse(1000L);
    }

    @PostMapping("/points/balance/skt")
    public ThirdPartyPointBalanceResponse balancePointSkt(
            @RequestBody ThirdPartyPointBalanceSktRequest thirdPartyPointBalanceSktRequest
    ) {
        log.info("skt");
        log.info("thirdPartyPointBalanceSktRequest: {}", thirdPartyPointBalanceSktRequest);
        log.info("=====");
        return new ThirdPartyPointBalanceResponse(2000L);
    }

    @GetMapping("/points/balance/kt")
    public ThirdPartyPointBalanceResponse balancePointKt(
            @RequestHeader("Authorization") String accessToken
    ) {
        log.info("kt");
        log.info("Header Authorization: {}", accessToken);
        log.info("=====");
        return new ThirdPartyPointBalanceResponse(3000L);
    }

    @GetMapping("/points/balance/ibk")
    public ThirdPartyPointBalanceResponse balancePointIbk(
            @RequestHeader("ci") String ci
    ) {
        log.info("ibk");
        log.info("Header ci: {}", ci);
        log.info("=====");
        return new ThirdPartyPointBalanceResponse(4000L);
    }

    @GetMapping("/points/balance/aptner")
    public ThirdPartyPointBalanceResponse balancePointAptner(
            @RequestParam("ci") String ci
    ) {
        log.info("aptner");
        log.info("ci: {}", ci);
        log.info("=====");
        return new ThirdPartyPointBalanceResponse(5000L);
    }
}
