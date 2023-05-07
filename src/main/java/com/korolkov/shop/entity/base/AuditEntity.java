package com.korolkov.shop.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@FieldDefaults(level = AccessLevel.PRIVATE)
@MappedSuperclass
@Getter
@Setter
public class AuditEntity extends BaseEntity {
    @Column(name = "createdBy")
    String createdBy;
    @Column(name = "updatedBy")
    String updatedBy;
    @Column(name = "deletedBy")
    String deletedBy;
    @Column(name = "createdAt")
    LocalDateTime createdAt;
    @Column(name = "updatedAt")
    LocalDateTime updatedAt;
    @Column(name = "deletedAt")
    LocalDateTime deletedAt;
}

