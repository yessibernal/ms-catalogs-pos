package com.innter.mscatalogspos.controllers;

import com.innter.mscatalogspos.dtos.request.EmployeeRequest;
import com.innter.mscatalogspos.dtos.request.EmployeeRequestEdited;
import com.innter.mscatalogspos.services.IEmployeeService;
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
@RequestMapping(value = "/api/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ResponseUtils responseUtils;

    @PreAuthorize("hasAnyRole ('ADMIN','DESIGN_WRITE')")
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        SuccessResponse responseSuccess = responseUtils.successResponseCreate(employeeService.saveEmployee(employeeRequest),
                GENERAL_CREATED);
        return new ResponseEntity<>(responseSuccess, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole ('ADMIN','DESIGN_WRITE')")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeRequestEdited employeeRequestEdited, @PathVariable long id) {
        SuccessResponse responseSuccess = responseUtils.successResponseOK(
                employeeService.editedEmployee(employeeRequestEdited, id),
                GENERAL_MODIFIED + id);
        return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") long id) {
        SuccessResponse responseSuccess = responseUtils.successResponseOK(employeeService.deleteEmployee(id),
                GENERAL_DELETED);
        return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
    }
}
