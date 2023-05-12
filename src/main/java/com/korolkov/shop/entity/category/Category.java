package com.korolkov.shop.entity.category;

import com.korolkov.shop.entity.product.Product;
import com.korolkov.shop.entity.base.AuditEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity(name = "category")
@Table(name = "product_category", schema = "shop")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "product_category_id")),
        @AttributeOverride(name = "createdBy", column = @Column(name = "product_category_created_by")),
        @AttributeOverride(name = "createdAt", column = @Column(name = "product_category_created_at")),
        @AttributeOverride(name = "updatedBy", column = @Column(name = "product_category_updated_by")),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "product_category_updated_at")),
        @AttributeOverride(name = "deletedBy", column = @Column(name = "product_category_deleted_by")),
        @AttributeOverride(name = "deletedAt", column = @Column(name = "product_category_deleted_at"))
})
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Getter
@Setter
@Where(clause = " product_category_deleted_by IS NULL ")
@AllArgsConstructor
@NoArgsConstructor
public class Category extends AuditEntity {
    @Column(name = "product_category_name")
    String name;
    @Column(name = "product_category_url")
    String url;
    @Column(name = "product_category_keyword")
    String keyword;
    @Column(name = "product_category_description")
    String description;
    @Column(name = "product_category_base_image")
    String baseImage;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_parent_id")
    Category parent;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    List<Product> product;
}
