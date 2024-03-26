package com.innter.mscatalogspos.controllers;

import com.innter.mscatalogspos.dtos.request.CustomerRequest;
import com.innter.mscatalogspos.dtos.request.CustomerRequestEdited;
import com.innter.mscatalogspos.services.ICustomerService;
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
@RequestMapping(value = "/api/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ResponseUtils responseUtils;

    @PreAuthorize("hasAnyRole ('ADMIN','DESIGN_WRITE')")
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createCustomer(@RequestBody CustomerRequest customerRequest) {
        SuccessResponse responseSuccess = responseUtils.successResponseCreate(customerService.saveCustomer(customerRequest),
                GENERAL_CREATED);
        return new ResponseEntity<>(responseSuccess, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole ('ADMIN','DESIGN_WRITE')")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerRequestEdited categoryRequestEdited, @PathVariable long id) {
        SuccessResponse responseSuccess = responseUtils.successResponseOK(
                customerService.editedCustomer(categoryRequestEdited, id),
                GENERAL_MODIFIED + id);
        return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") long id) {
        SuccessResponse responseSuccess = responseUtils.successResponseOK(customerService.deleteCustomer(id),
                GENERAL_DELETED);
        return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
    }
}
