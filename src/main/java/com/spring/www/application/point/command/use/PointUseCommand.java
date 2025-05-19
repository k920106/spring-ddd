package com.spring.www.application.point.command.use;

import com.spring.www.infrastructure.persistence.point.ExternalPointGateway;

public interface PointUseCommand {
    Long processUse(ExternalPointGateway reader);
}
