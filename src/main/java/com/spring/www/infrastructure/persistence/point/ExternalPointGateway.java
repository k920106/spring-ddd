package com.spring.www.infrastructure.persistence.point;

import com.spring.www.presentation.common.CommonResponse;
import com.spring.www.domain.point.PointGateway;
import com.spring.www.domain.user.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

/**
 * 포인트 조회 인터페이스의 구현체입니다.
 */
@RequiredArgsConstructor
@Component
public class ExternalPointGateway implements PointGateway {
    @Override
    public Long balance(User user) {
        return switch (user.companyId().toLowerCase()) {
            case "skt" -> processSktPointBalance(user.ci());
            case "kt" -> processKtPointBalance(user.accessToken());
            case "ibk" -> processIbkPointBalance(user.ci());
            case "aptner" -> processAptNerPointBalance(user.ci());
            default -> processBasePointBalance(user.accessToken());
        };
    }

    @Override
    public Long use() {
        RestClient restClient = RestClient.create();
        return 0L;
    }

    public Long processBasePointBalance(String accessToken) {
        RestClient restClient = RestClient.create();

        ExternalPointBalanceRequest request = ExternalPointBalanceRequest.from(accessToken);
        ResponseEntity<CommonResponse<ExternalPointBalanceResponse>> response =
            restClient.post()
                      .uri("http://localhost:8080/api/third-party/points/balance")
                      .body(request)
                      .retrieve()
                      .toEntity(new ParameterizedTypeReference<>() {});

        ExternalPointBalanceResponse data = Objects.requireNonNull(response.getBody()).data();
        return data.balance();
    }

    public Long processSktPointBalance(String ci) {
        RestClient restClient = RestClient.create();

        ExternalPointBalanceSktRequest request = ExternalPointBalanceSktRequest.from(ci);
        ResponseEntity<CommonResponse<ExternalPointBalanceResponse>> response =
            restClient.post()
                      .uri("http://localhost:8080/api/third-party/points/balance/skt")
                      .body(request)
                      .retrieve()
                      .toEntity(new ParameterizedTypeReference<>() {});

        ExternalPointBalanceResponse data = Objects.requireNonNull(response.getBody()).data();
        return data.balance();
    }

    public Long processKtPointBalance(String accessToken) {
        RestClient restClient = RestClient.create();
        ResponseEntity<CommonResponse<ExternalPointBalanceResponse>> response =
            restClient.get()
                      .uri("http://localhost:8080/api/third-party/points/balance/kt")
                      .header("Authorization", "Bearer " + accessToken)
                      .retrieve()
                      .toEntity(new ParameterizedTypeReference<>() {});

        ExternalPointBalanceResponse data = Objects.requireNonNull(response.getBody()).data();
        return data.balance();
    }

    public Long processIbkPointBalance(String ci) {
        RestClient restClient = RestClient.create();
        ResponseEntity<CommonResponse<ExternalPointBalanceResponse>> response =
            restClient.get()
                      .uri("http://localhost:8080/api/third-party/points/balance/ibk")
                      .header("ci", ci)
                      .retrieve()
                      .toEntity(new ParameterizedTypeReference<>() {});

        ExternalPointBalanceResponse data = Objects.requireNonNull(response.getBody()).data();
        return data.balance();
    }

    public Long processAptNerPointBalance(String ci) {
        RestClient restClient = RestClient.create();
        ResponseEntity<CommonResponse<ExternalPointBalanceResponse>> response =
            restClient.get()
                      .uri(uriBuilder -> uriBuilder.scheme("http")
                                                             .host("localhost")
                                                             .port(8080)
                                                             .path("/api/third-party/points/balance/aptner")
                                                             .queryParam("ci", ci)
                                                             .build())
                      .retrieve()
                      .toEntity(new ParameterizedTypeReference<>() {});

        ExternalPointBalanceResponse data = Objects.requireNonNull(response.getBody()).data();
        return data.balance();
    }
}
