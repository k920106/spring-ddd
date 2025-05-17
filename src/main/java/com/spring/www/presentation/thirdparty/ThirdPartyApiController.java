package com.spring.www.presentation.thirdparty;

import com.spring.www.presentation.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/third-party")
@RestController
public class ThirdPartyApiController {
    @PostMapping("/points/balance")
    public ResponseEntity<CommonResponse<ThirdPartyPointBalanceResponse>> balancePoint(@RequestBody ThirdPartyPointBalanceRequest thirdPartyPointBalanceRequest) {
        System.out.println("ThirdPartyPointBalanceRequest: " + thirdPartyPointBalanceRequest);
        return ResponseEntity.ok(new CommonResponse<>(new ThirdPartyPointBalanceResponse(1000L)));
    }
}
