package com.innter.mscatalogspos.mappers;

import com.innter.mscatalogspos.dtos.request.CustomerRequest;
import com.innter.mscatalogspos.dtos.response.CustomerResponse;
import com.innter.mscatalogspos.entities.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper implements ICustomerMapper {
    @Override
    public CustomerResponse customerToCustomerResponse(CustomerEntity customer) {
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(customer.getId());
        customerResponse.setName(customer.getName());
        customerResponse.setLastName(customer.getLastName());
        customerResponse.setGender(customer.getGender());
        customerResponse.setBirthDate(customer.getBirthDate());
        customerResponse.setDocumentType(customer.getDocumentType());
        customerResponse.setDocumentNumber(customer.getDocumentNumber());
        customerResponse.setAddress(customer.getAddress());
        customerResponse.setPhone(customer.getPhone());
        customerResponse.setEmail(customer.getEmail());
        return customerResponse;
    }

    @Override
    public CustomerEntity customerRequestToCustomer(CustomerRequest customerRequest) {
        CustomerEntity customer = new CustomerEntity();
        customer.setName(customerRequest.getName());
        customer.setLastName(customerRequest.getLastName());
        customer.setGender(customerRequest.getGender());
        customer.setBirthDate(customerRequest.getBirthDate());
        customer.setDocumentType(customerRequest.getDocumentType());
        customer.setDocumentNumber(customerRequest.getDocumentNumber());
        customer.setAddress(customerRequest.getAddress());
        customer.setPhone(customerRequest.getPhone());
        customer.setEmail(customerRequest.getEmail());
        return customer;
    }
}
