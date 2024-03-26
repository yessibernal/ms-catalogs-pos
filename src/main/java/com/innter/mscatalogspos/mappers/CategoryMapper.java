package com.innter.mscatalogspos.mappers;

import com.innter.mscatalogspos.dtos.request.CategoryRequest;
import com.innter.mscatalogspos.dtos.response.CategoryResponse;
import com.innter.mscatalogspos.entities.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper implements ICategoryMapper {
    @Override
    public CategoryResponse categoryToCategoryResponse(CategoryEntity category) {
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setId(category.getId());
        categoryResponse.setName(category.getName());
        categoryResponse.setDescription(category.getDescription());
        return categoryResponse;
    }

    @Override
    public CategoryEntity categoryRequestToCategory(CategoryRequest categoryRequest) {
        CategoryEntity category = new CategoryEntity();
        category.setName(categoryRequest.getName());
        category.setDescription(categoryRequest.getDescription());
        return category;
    }
}
