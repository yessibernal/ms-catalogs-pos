package com.innter.mscatalogspos.services.IMPL;

import com.innter.mscatalogspos.dtos.request.EmployeeRequest;
import com.innter.mscatalogspos.dtos.request.EmployeeRequestEdited;
import com.innter.mscatalogspos.dtos.response.EmployeeResponse;
import com.innter.mscatalogspos.entities.EmployeeEntity;
import com.innter.mscatalogspos.exceptions.BadRequestCatalog;
import com.innter.mscatalogspos.exceptions.NotFoundCatalog;
import com.innter.mscatalogspos.mappers.EmployeeMapper;
import com.innter.mscatalogspos.repositories.EmployeeRepository;
import com.innter.mscatalogspos.services.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.innter.mscatalogspos.constants.MassageErrorConstantsCatalogs.*;
import static com.innter.mscatalogspos.constants.MassageErrorConstantsCatalogs.ERROR_GENERAL_NOT_FOUND;

@Service
@Slf4j
public class EmployeeService implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    @Override
    public EmployeeResponse saveEmployee(EmployeeRequest employeeRequest) {
        try {
            EmployeeEntity employee = employeeMapper.employeeRequestToEmployee(employeeRequest);
            employeeRepository.save(employee);
            return employeeMapper.employeeToEmployeeResponse(employee);
        } catch (Exception e) {
            throw new BadRequestCatalog(P_400, HttpStatus.BAD_REQUEST, ERROR_GENERAL_NOT_CREATED);
        }
    }

    @Transactional
    @Override
    public EmployeeResponse editedEmployee(EmployeeRequestEdited employeeRequestEdited, Long id) {
        EmployeeEntity employee = findEmployeeById(employeeRepository.findById(id));
        if (!employeeRepository.findById(id).isEmpty()) {
            employee.setAddress(employeeRequestEdited.getAddress());
            employee.setPhone(employeeRequestEdited.getPhone());
            employee.setEmail(employeeRequestEdited.getEmail());
            employee.setAccess(employeeRequestEdited.getAccess());
            employee.setUser(employeeRequestEdited.getUser());
            employee.setPassword(employeeRequestEdited.getPassword());
            return employeeMapper.employeeToEmployeeResponse(employee);
        }
        throw new BadRequestCatalog(P_404, HttpStatus.BAD_REQUEST, ERROR_GENERAL_NOT_EDITED);
    }

    @Override
    public Boolean deleteEmployee(Long id) {
        try {
            employeeRepository.deleteById(id);
            return Boolean.TRUE;
        } catch (Exception e) {
            throw new BadRequestCatalog(P_404, HttpStatus.BAD_REQUEST, ERROR_GENERAL_NOT_DELETED);
        }
    }

    private EmployeeEntity findEmployeeById(Optional<EmployeeEntity> optionalEmployeeEntity) {
        return optionalEmployeeEntity.orElseThrow(() -> new NotFoundCatalog(P_404, HttpStatus.NOT_FOUND, ERROR_GENERAL_NOT_FOUND));
    }
}
