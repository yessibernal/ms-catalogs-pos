package com.innter.mscatalogspos.services;

import com.innter.mscatalogspos.dtos.request.EmployeeRequest;
import com.innter.mscatalogspos.dtos.request.EmployeeRequestEdited;
import com.innter.mscatalogspos.dtos.response.EmployeeResponse;

public interface IEmployeeService {
    EmployeeResponse saveEmployee(EmployeeRequest employeeRequest);

    EmployeeResponse editedEmployee(EmployeeRequestEdited employeeRequestEdited, Long id);

    Boolean deleteEmployee(Long id);
}
