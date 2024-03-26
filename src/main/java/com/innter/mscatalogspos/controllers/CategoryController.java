package com.innter.mscatalogspos.controllers;

import com.innter.mscatalogspos.dtos.request.CategoryRequest;
import com.innter.mscatalogspos.dtos.request.CategoryRequestEdited;
import com.innter.mscatalogspos.services.ICategoryService;
import com.innter.mscatalogspos.utils.ResponseUtils;
import com.innter.mscatalogspos.utils.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static com.innter.mscatalogspos.constants.MassageConstantsCatalogs.*;

@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ResponseUtils responseUtils;

    @PreAuthorize("hasAnyRole ('ADMIN','DESIGN_WRITE')")
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createCategory(@RequestBody CategoryRequest categoryRequest) {
        SuccessResponse responseSuccess = responseUtils.successResponseCreate(categoryService.saveCategory(categoryRequest),
                GENERAL_CREATED);
        return new ResponseEntity<>(responseSuccess, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole ('ADMIN','DESIGN_WRITE')")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateCategory(@RequestBody CategoryRequestEdited categoryRequestEdited, @PathVariable long id) {
        SuccessResponse responseSuccess = responseUtils.successResponseOK(
                categoryService.editedCategory(categoryRequestEdited, id),
                GENERAL_MODIFIED + id);
        return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteCategory(@PathVariable("id") long id) {
        SuccessResponse responseSuccess = responseUtils.successResponseOK(categoryService.deleteCategory(id),
                GENERAL_DELETED);
        return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
    }
}
