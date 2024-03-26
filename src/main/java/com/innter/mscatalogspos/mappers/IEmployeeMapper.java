package com.innter.mscatalogspos.mappers;

import com.innter.mscatalogspos.dtos.request.EmployeeRequest;
import com.innter.mscatalogspos.dtos.response.EmployeeResponse;
import com.innter.mscatalogspos.entities.EmployeeEntity;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface IEmployeeMapper {

    EmployeeResponse employeeToEmployeeResponse(EmployeeEntity employee);

    EmployeeEntity employeeRequestToEmployee(EmployeeRequest employeeRequest);
}
