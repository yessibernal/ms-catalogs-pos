package com.innter.mscatalogspos.services.IMPL;

import com.innter.mscatalogspos.dtos.request.CustomerRequest;
import com.innter.mscatalogspos.dtos.request.CustomerRequestEdited;
import com.innter.mscatalogspos.dtos.response.CustomerResponse;
import com.innter.mscatalogspos.entities.CategoryEntity;
import com.innter.mscatalogspos.entities.CustomerEntity;
import com.innter.mscatalogspos.exceptions.BadRequestCatalog;
import com.innter.mscatalogspos.exceptions.NotFoundCatalog;
import com.innter.mscatalogspos.mappers.CustomerMapper;
import com.innter.mscatalogspos.repositories.CustomerRepository;
import com.innter.mscatalogspos.services.ICustomerService;
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
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    @Override
    public CustomerResponse saveCustomer(CustomerRequest customerRequest) {
        try {
            CustomerEntity customer = customerMapper.customerRequestToCustomer(customerRequest);
            customerRepository.save(customer);
            return customerMapper.customerToCustomerResponse(customer);
        } catch (Exception e) {
            throw new BadRequestCatalog(P_400, HttpStatus.BAD_REQUEST, ERROR_GENERAL_NOT_CREATED);
        }
    }

    @Transactional
    @Override
    public CustomerResponse editedCustomer(CustomerRequestEdited customerRequestEdited, Long id) {
        CustomerEntity customer = findCustomerById(customerRepository.findById(id));
        if (!customerRepository.findById(id).isEmpty()) {
            customer.setDocumentType(customerRequestEdited.getDocumentType());
            customer.setDocumentNumber(customerRequestEdited.getDocumentNumber());
            customer.setAddress(customerRequestEdited.getAddress());
            customer. setPhone(customerRequestEdited.getPhone());
            customer.setEmail(customerRequestEdited.getEmail());
            return customerMapper.customerToCustomerResponse(customer);
        }
        throw new BadRequestCatalog(P_404, HttpStatus.BAD_REQUEST, ERROR_GENERAL_NOT_EDITED);
    }

    @Override
    public Boolean deleteCustomer(Long id) {
        try {
            customerRepository.deleteById(id);
            return Boolean.TRUE;
        } catch (Exception e) {
            throw new BadRequestCatalog(P_404, HttpStatus.BAD_REQUEST, ERROR_GENERAL_NOT_DELETED);
        }
    }

    private CustomerEntity findCustomerById(Optional<CustomerEntity> optionalCustomerEntity) {
        return optionalCustomerEntity.orElseThrow(() -> new NotFoundCatalog(P_404, HttpStatus.NOT_FOUND, ERROR_GENERAL_NOT_FOUND));
    }
}
