package com.innter.mscatalogspos.services;

import com.innter.mscatalogspos.dtos.request.CategoryRequest;
import com.innter.mscatalogspos.dtos.request.CategoryRequestEdited;
import com.innter.mscatalogspos.dtos.response.CategoryResponse;

public interface ICategoryService {
    CategoryResponse saveCategory(CategoryRequest categoryRequest);

    CategoryResponse editedCategory(CategoryRequestEdited categoryRequestEdited, Long id);

    Boolean deleteCategory(Long id);
}
