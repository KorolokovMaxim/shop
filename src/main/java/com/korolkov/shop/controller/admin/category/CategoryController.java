package com.korolkov.shop.controller.admin.category;

import com.korolkov.shop.controller.BaseCRUDController;
import com.korolkov.shop.dto.category.CategoryDTO;
import com.korolkov.shop.service.admin.category.CategoryService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/admin/category")
@RequiredArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
public class CategoryController implements BaseCRUDController<CategoryDTO> {
    CategoryService service;

    @Override
    @PostMapping
    public void create( @RequestBody CategoryDTO request) {
        service.create(request);
    }

    @Override
    @DeleteMapping
    public void delete(UUID id) {
        service.delete(id);
    }

    @Override
    @GetMapping(value = "/get-all")
    public List<CategoryDTO> getAll() {
        return service.getAll();
    }

    @Override
    @GetMapping(value = "/get-one")
    public CategoryDTO getOne(UUID id) {
        return service.getOne(id);
    }
}
