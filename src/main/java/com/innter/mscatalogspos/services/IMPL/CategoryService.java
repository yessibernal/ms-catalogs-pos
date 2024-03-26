package com.innter.mscatalogspos.services.IMPL;

import com.innter.mscatalogspos.dtos.request.CategoryRequest;
import com.innter.mscatalogspos.dtos.request.CategoryRequestEdited;
import com.innter.mscatalogspos.dtos.response.CategoryResponse;
import com.innter.mscatalogspos.entities.CategoryEntity;
import com.innter.mscatalogspos.exceptions.BadRequestCatalog;
import com.innter.mscatalogspos.exceptions.NotFoundCatalog;
import com.innter.mscatalogspos.mappers.CategoryMapper;
import com.innter.mscatalogspos.repositories.CategoryRepository;
import com.innter.mscatalogspos.services.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.innter.mscatalogspos.constants.MassageErrorConstantsCatalogs.*;

@Service
@Slf4j
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    @Override
    public CategoryResponse saveCategory(CategoryRequest categoryRequest) {
        try {
            CategoryEntity category = categoryMapper.categoryRequestToCategory(categoryRequest);
            categoryRepository.save(category);
            return categoryMapper.categoryToCategoryResponse(category);
        } catch (Exception e) {
            throw new BadRequestCatalog(P_400, HttpStatus.BAD_REQUEST, ERROR_GENERAL_NOT_CREATED);
        }
    }

    @Transactional
    @Override
    public CategoryResponse editedCategory(CategoryRequestEdited categoryRequestEdited, Long id) {
        CategoryEntity category = findCategoryById(categoryRepository.findById(id));
        if (!categoryRepository.findById(id).isEmpty()) {
            category.setDescription(categoryRequestEdited.getDescription());
            categoryRepository.save(category);
            return categoryMapper.categoryToCategoryResponse(category);
        }
        throw new BadRequestCatalog(P_404, HttpStatus.BAD_REQUEST, ERROR_GENERAL_NOT_EDITED);
    }

    @Override
    public Boolean deleteCategory(Long id) {
        try {
            categoryRepository.deleteById(id);
            return Boolean.TRUE;
        } catch (Exception e) {
            throw new BadRequestCatalog(P_404, HttpStatus.BAD_REQUEST, ERROR_GENERAL_NOT_DELETED);
        }
    }


    private CategoryEntity findCategoryById(Optional<CategoryEntity> optionalCategoryEntity) {
        return optionalCategoryEntity.orElseThrow(() -> new NotFoundCatalog(P_404, HttpStatus.NOT_FOUND, ERROR_GENERAL_NOT_FOUND));
    }
}
