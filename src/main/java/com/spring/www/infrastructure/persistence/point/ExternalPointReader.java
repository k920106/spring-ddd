package com.spring.www.infrastructure.persistence.point;

import com.spring.www.application.point.command.balance.*;
import com.spring.www.domain.point.PointReader;
import com.spring.www.presentation.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Objects;

/**
 * 방문자 패턴 (Visitor)
 * 객체 구조를 변경하지 않고 새로운 연산을 추가할 수 있게 합니다.
 */
@RequiredArgsConstructor
@Component
public class ExternalPointReader implements PointReader {
    @Override
    public Long balance(PointBalanceCommand command) {
        return command.process(this);
    }

    @Override
    public Long use() {
        RestClient restClient = RestClient.create();
        return 0L;
    }

    // 기본 프로세스
    // [POST] body (accessToken)
    public Long processBasePointBalance(BasePointBalanceCommand command) {
        RestClient restClient = RestClient.create();
        ResponseEntity<CommonResponse<ExternalPointBalanceResponse>> response =
                restClient.post()
                          .uri("http://localhost:8080/api/third-party/points/balance")
                          .body(command)
                          .retrieve()
                          .toEntity(new ParameterizedTypeReference<>() {});

        ExternalPointBalanceResponse data = Objects.requireNonNull(response.getBody()).data();
        return data.balance();
    }

    // [POST] body (ci)
    public Long processSktPointBalance(SktPointBalanceCommand command) {
        RestClient restClient = RestClient.create();
        ResponseEntity<CommonResponse<ExternalPointBalanceResponse>> response =
                restClient.post()
                          .uri("http://localhost:8080/api/third-party/points/balance/skt")
                          .body(command)
                          .retrieve()
                          .toEntity(new ParameterizedTypeReference<>() {});

        ExternalPointBalanceResponse data = Objects.requireNonNull(response.getBody()).data();
        return data.balance();
    }

    // [GET] Header (accessToken)
    public Long processKtPointBalance(ktPointBalanceCommand command) {
        RestClient restClient = RestClient.create();
        ResponseEntity<CommonResponse<ExternalPointBalanceResponse>> response =
                restClient.get()
                          .uri("http://localhost:8080/api/third-party/points/balance/kt")
                          .header("Authorization", "Bearer " + command.accessToken())
                          .retrieve()
                          .toEntity(new ParameterizedTypeReference<>() {});

        ExternalPointBalanceResponse data = Objects.requireNonNull(response.getBody()).data();
        return data.balance();
    }

    // [GET] Header (ci)
    public Long processIbkPointBalance(IbkPointBalanceCommand command) {
        RestClient restClient = RestClient.create();
        ResponseEntity<CommonResponse<ExternalPointBalanceResponse>> response =
                restClient.get()
                          .uri("http://localhost:8080/api/third-party/points/balance/ibk")
                          .header("ci", command.ci())
                          .retrieve()
                          .toEntity(new ParameterizedTypeReference<>() {});

        ExternalPointBalanceResponse data = Objects.requireNonNull(response.getBody()).data();
        return data.balance();
    }

    // [GET] queryString (ci)
    public Long processAptNerPointBalance(AptnerPointBalanceCommand command) {
        RestClient restClient = RestClient.create();
        ResponseEntity<CommonResponse<ExternalPointBalanceResponse>> response =
                restClient.get()
                          .uri(uriBuilder ->
                                        uriBuilder.scheme("http")
                                                  .host("localhost")
                                                  .port(8080)
                                                  .path("/api/third-party/points/balance/aptner")
                                                  .queryParam("ci", command.ci())
                                                  .build())
                          .retrieve()
                          .toEntity(new ParameterizedTypeReference<>() {});

        ExternalPointBalanceResponse data = Objects.requireNonNull(response.getBody()).data();
        return data.balance();
    }
}
