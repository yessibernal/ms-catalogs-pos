package com.innter.mscatalogspos.mappers;

import com.innter.mscatalogspos.dtos.request.EmployeeRequest;
import com.innter.mscatalogspos.dtos.response.EmployeeResponse;
import com.innter.mscatalogspos.entities.EmployeeEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper implements IEmployeeMapper {
    @Override
    public EmployeeResponse employeeToEmployeeResponse(EmployeeEntity employee) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(employee.getId());
        employeeResponse.setName(employee.getName());
        employeeResponse.setLastName(employee.getLastName());
        employeeResponse.setGender(employee.getGender());
        employeeResponse.setBirthDate(employee.getBirthDate());
        employeeResponse.setCurp(employee.getCurp());
        employeeResponse.setAddress(employee.getAddress());
        employeeResponse.setPhone(employee.getPhone());
        employeeResponse.setEmail(employee.getEmail());
        employeeResponse.setAccess(employee.getAccess());
        employeeResponse.setUser(employee.getUser());
        employeeResponse.setPassword(employee.getPassword());
        return employeeResponse;
    }

    @Override
    public EmployeeEntity employeeRequestToEmployee(EmployeeRequest employeeRequest) {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setName(employeeRequest.getName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setGender(employeeRequest.getGender());
        employee.setBirthDate(employeeRequest.getBirthDate());
        employee.setCurp(employeeRequest.getCurp());
        employee.setAddress(employeeRequest.getAddress());
        employee.setPhone(employeeRequest.getPhone());
        employee.setEmail(employeeRequest.getEmail());
        employee.setAccess(employeeRequest.getAccess());
        employee.setUser(employeeRequest.getUser());
        employee.setPassword(employeeRequest.getPassword());
        return employee;
    }
}
