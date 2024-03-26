package com.innter.mscatalogspos.controllers;

import com.innter.mscatalogspos.dtos.request.ProviderRequest;
import com.innter.mscatalogspos.dtos.request.ProviderRequestEdited;
import com.innter.mscatalogspos.services.IProviderService;
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
@RequestMapping(value = "api/provider")
public class ProviderController {

    @Autowired
    private IProviderService providerService;

    @Autowired
    private ResponseUtils responseUtils;

    @PreAuthorize("hasAnyRole ('ADMIN','DESIGN_WRITE')")
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createProvider(@RequestBody ProviderRequest providerRequest) {
        SuccessResponse responseSuccess = responseUtils.successResponseCreate(providerService.saveProvider(providerRequest),
                GENERAL_CREATED);
        return new ResponseEntity<>(responseSuccess, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole ('ADMIN','DESIGN_WRITE')")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateProvider(@RequestBody ProviderRequestEdited providerRequestEdited, @PathVariable long id) {
        SuccessResponse responseSuccess = responseUtils.successResponseOK(
                providerService.editedProvider(providerRequestEdited, id),
                GENERAL_MODIFIED + id);
        return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteProvider(@PathVariable("id") long id) {
        SuccessResponse responseSuccess = responseUtils.successResponseOK(providerService.deleteProvider(id),
                GENERAL_DELETED);
        return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
    }
}
