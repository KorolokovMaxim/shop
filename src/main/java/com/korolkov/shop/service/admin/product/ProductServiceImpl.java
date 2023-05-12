package com.korolkov.shop.service.admin.product;

import com.korolkov.shop.dto.product.ProductDTO;
import com.korolkov.shop.entity.category.Category;
import com.korolkov.shop.entity.product.Product;
import com.korolkov.shop.repository.category.CategoryRepository;
import com.korolkov.shop.repository.product.ProductRepository;
import com.korolkov.shop.utils.SecurityHelper;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductServiceImpl implements ProductService {

    ProductRepository repository;
    CategoryRepository categoryRepository;

    @Override
    public void create(ProductDTO request) {
        Product product;
        if (request.getId() != null) {
            product = repository.findById(request.getId())
                    .orElseThrow(() -> new RuntimeException("Категория не найдена"));
        } else {
            product = new Product();
        }
        UUID categoryId = request.getCategoryId();
        if (categoryId != null) {
            Optional<Category> category = categoryRepository.findById(categoryId);
            category.ifPresent(product::setCategory);
        }
        BeanUtils.copyProperties(request, product);
        repository.saveAndFlush(product);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteSoft(id, SecurityHelper.getLoggedUser(), LocalDateTime.now());
    }

    @Override
    public List<ProductDTO> getAll() {
        return repository.findAll()
                .stream().map(ProductDTO::new)
                .toList();
    }

    @Override
    public ProductDTO getOne(UUID id) {
        return new ProductDTO(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Категория не найдена")));
    }
}
