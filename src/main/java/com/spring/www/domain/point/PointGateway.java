package com.spring.www.domain.point;

import com.spring.www.domain.user.User;

/**
 * 포인트 조회 관련 기능을 정의합니다.
 */
public interface PointGateway {
    Long balance(User user);
    Long use();
}
