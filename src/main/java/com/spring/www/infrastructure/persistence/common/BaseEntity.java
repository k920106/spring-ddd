package com.spring.www.infrastructure.persistence.common;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseEntity {
  @CreatedDate
  @Column(name="created_at", updatable = false)
  private LocalDateTime createdAt;

  @LastModifiedDate
  @Column(name="updated_at")
  private LocalDateTime updatedAt;
}
