package com.korolkov.shop.dto.category;

import com.korolkov.shop.dto.AuditEntityDTO;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO extends AuditEntityDTO {
    String name;
    String url;
    String keyword;
    String description;
    String baseImage;
}
