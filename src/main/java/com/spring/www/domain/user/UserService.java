package com.spring.www.domain.user;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    public User getUser(String companyId) {
        return getUsers().stream()
            .filter(user -> user.companyId().equals(companyId))
            .findFirst()
            .orElse(null);
    }


    private List<User> getUsers() {
        return List.of(
            User.builder().companyId("lg").accessToken("accessToken").ci("").build(),
            User.builder().companyId("skt").accessToken("").ci("ci").build(),
            User.builder().companyId("kt").accessToken("accessToken").ci("").build(),
            User.builder().companyId("ibk").accessToken("").ci("ci").build(),
            User.builder().companyId("aptner").accessToken("").ci("ci").build()
        );
    }
}
