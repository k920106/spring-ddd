package com.spring.www.domain.order;

import org.junit.jupiter.api.Test;

class OrderUserTest {
    @Test
    public void validateBlankAll() {
        OrderUser.of("", "");
    }

    @Test
    public void validateBlankOdrerNm() {
        OrderUser.of("", "odrerTelNo");
    }

    @Test
    public void validateBlankOdrerTelNo() {
        OrderUser.of("odrerNm", "");
    }
}
