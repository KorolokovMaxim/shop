package com.korolkov.shop.entity.product;

import com.korolkov.shop.entity.base.AuditEntity;
import com.korolkov.shop.entity.category.Category;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Where;

@Entity(name = "product")
@Table(name = "product", schema = "shop")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "product_id")),
        @AttributeOverride(name = "createdBy", column = @Column(name = "product_created_by")),
        @AttributeOverride(name = "createdAt", column = @Column(name = "product_created_at")),
        @AttributeOverride(name = "updatedBy", column = @Column(name = "product_updated_by")),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "product_updated_at")),
        @AttributeOverride(name = "deletedBy", column = @Column(name = "product_deleted_by")),
        @AttributeOverride(name = "deletedAt", column = @Column(name = "product_deleted_at"))
})
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Getter
@Setter
@Where(clause = " product_deleted_by IS NULL ")
@AllArgsConstructor
@NoArgsConstructor
public class Product extends AuditEntity {
    @Column(name = "product_name")
    String name;
    @Column(name = "product_keyword")
    String keyword;
    @Column(name = "product_url")
    String url;
    @Column(name = "product_description")
    String description;
    @Column(name = "product_base_image")
    String productBaseImage;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    Category category;
}
