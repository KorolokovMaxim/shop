package com.korolkov.shop.service.admin.category;

import com.korolkov.shop.dto.category.CategoryDTO;
import com.korolkov.shop.entity.category.Category;
import com.korolkov.shop.repository.category.CategoryRepository;
import com.korolkov.shop.utils.SecurityHelper;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class CategoryServiceImpl implements CategoryService{

    CategoryRepository repository;

    @Override
    @Transactional
    public void create(CategoryDTO request) {
        Category category;
        if(request.getId() != null){
            category = repository.findById(request.getId())
                    .orElseThrow( () -> new RuntimeException("Категория не найдена"));
        }else{
            category = new Category();
        }
        BeanUtils.copyProperties(request , category);
        repository.saveAndFlush(category);

    }

    @Override
    @Transactional
    public void delete(UUID id) {
        repository.deleteSoft(id , SecurityHelper.getLoggedUser(), LocalDateTime.now());
    }

    @Override
    public List<CategoryDTO> getAll() {
        return repository.findAll()
                .stream().map(CategoryDTO::new)
                .toList();
    }

    @Override
    public CategoryDTO getOne(UUID id) {
        Category category = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Категория не найдена"));
        return new CategoryDTO(category);
    }
}
