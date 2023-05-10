package com.korolkov.shop.dto.category;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.korolkov.shop.dto.AuditEntityDTO;
import com.korolkov.shop.entity.category.Category;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;

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

    public CategoryDTO(Category entity) {
        BeanUtils.copyProperties(entity , this);
    }
}
