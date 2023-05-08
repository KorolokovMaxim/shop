package com.korolkov.shop.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuditEntityDTO extends BaseDTO{
    String createdBy;
    LocalDateTime createdAt;
    String updatedBy;
    LocalDateTime updatedAt;
    String deletedBy;
    LocalDateTime deletedAt;
}
