package com.spring.www.application.point.command.use;

import com.spring.www.infrastructure.persistence.point.ExternalPointReader;

public interface PointUseCommand {
    Long processUse(ExternalPointReader reader);
}
