package com.spring.www.infrastructure.persistence.point;

import com.spring.www.domain.point.PointReader;
import com.spring.www.presentation.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Objects;

@RequiredArgsConstructor
@Component
public class ExternalPointReader implements PointReader {
    @Override
    public Long balance() {
        RestClient restClient = RestClient.create();

        ExternalPointBalanceRequest request = ExternalPointBalanceRequest.builder().accessToken("abc").build();
        ResponseEntity<CommonResponse<ExternalPointBalanceResponse>> response =
                restClient.post()
                          .uri("http://localhost:8080/api/third-party/points/balance")
                          .body(request)
                          .retrieve()
                          .toEntity(new ParameterizedTypeReference<>() {});


        ExternalPointBalanceResponse data = Objects.requireNonNull(response.getBody()).data();
        return data.balance();
    }

    @Override
    public Long use() {
        RestClient restClient = RestClient.create();

        return 0L;
    }
}
