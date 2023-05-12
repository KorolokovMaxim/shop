package com.korolkov.shop.dto.product;

import com.korolkov.shop.dto.AuditEntityDTO;
import com.korolkov.shop.entity.category.Category;
import com.korolkov.shop.entity.product.Product;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;

import java.util.Objects;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDTO extends AuditEntityDTO {

    String name;
    String keyword;
    String url;
    String description;
    String productBaseImage;
    String categoryName;
    UUID categoryId;

    public ProductDTO(Product product) {
        if (!Objects.isNull(product)) {
            Category category = product.getCategory();
            if (!Objects.isNull(category)) {
                this.categoryName = category.getName();
                this.categoryId = category.getId();
            }
            BeanUtils.copyProperties(product, this);
        }
    }

}
