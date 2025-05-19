package com.spring.www.domain.point;

import com.spring.www.domain.user.User;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PointService {
    private final PointGateway pointGateway;

    public Long balance(User user) {
        return pointGateway.balance(user);
    }

    public Long use() {
        return pointGateway.use();
    }
}
