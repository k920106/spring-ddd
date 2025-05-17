package com.spring.www.domain.point;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PointService {
    private final PointReader pointReader;

    public Long balance() {
        return pointReader.balance();
    }

    public Long use() {
        return pointReader.use();
    }
}
