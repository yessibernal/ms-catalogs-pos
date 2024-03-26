package com.innter.mscatalogspos.controllers;

import com.innter.mscatalogspos.dtos.request.PresentationRequest;
import com.innter.mscatalogspos.dtos.request.PresentationRequestEdited;
import com.innter.mscatalogspos.services.IPresentationService;
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
@RequestMapping(value = "api/presentation")
public class PresentationController {
    @Autowired
    private IPresentationService presentationService;

    @Autowired
    private ResponseUtils responseUtils;

    @PreAuthorize("hasAnyRole ('ADMIN','DESIGN_WRITE')")
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createPresentation(@RequestBody PresentationRequest presentationRequest) {
        SuccessResponse responseSuccess = responseUtils.successResponseCreate(presentationService.savePresentation(presentationRequest),
                GENERAL_CREATED);
        return new ResponseEntity<>(responseSuccess, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole ('ADMIN','DESIGN_WRITE')")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updatePresentation(@RequestBody PresentationRequestEdited presentationRequestEdited, @PathVariable long id) {
        SuccessResponse responseSuccess = responseUtils.successResponseOK(
                presentationService.editedPresentation(presentationRequestEdited, id),
                GENERAL_MODIFIED + id);
        return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deletePresentation(@PathVariable("id") long id) {
        SuccessResponse responseSuccess = responseUtils.successResponseOK(presentationService.deletePresentation(id),
                GENERAL_DELETED);
        return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
    }
}
