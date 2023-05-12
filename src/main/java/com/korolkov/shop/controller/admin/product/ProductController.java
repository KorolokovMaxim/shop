package com.korolkov.shop.controller.admin.product;

import com.korolkov.shop.controller.BaseCRUDController;
import com.korolkov.shop.dto.product.ProductDTO;
import com.korolkov.shop.service.admin.product.ProductService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/admin/product")
@RequiredArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
public class ProductController implements BaseCRUDController<ProductDTO> {

    ProductService service;

    @Override
    public void create(ProductDTO request) {
        service.create(request);
    }

    @Override
    public void delete(UUID id) {
        service.delete(id);
    }

    @Override
    public List<ProductDTO> getAll() {
        return service.getAll();
    }

    @Override
    public ProductDTO getOne(UUID id) {
        return service.getOne(id);
    }
}
