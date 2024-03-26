package com.innter.mscatalogspos.mappers;

import com.innter.mscatalogspos.dtos.request.CategoryRequest;
import com.innter.mscatalogspos.dtos.response.CategoryResponse;
import com.innter.mscatalogspos.entities.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface ICategoryMapper {

    CategoryResponse categoryToCategoryResponse(CategoryEntity category);

    CategoryEntity categoryRequestToCategory(CategoryRequest categoryRequest);
}
