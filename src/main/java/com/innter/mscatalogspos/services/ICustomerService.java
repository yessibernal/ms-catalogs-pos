package com.innter.mscatalogspos.services;

import com.innter.mscatalogspos.dtos.request.CustomerRequest;
import com.innter.mscatalogspos.dtos.request.CustomerRequestEdited;
import com.innter.mscatalogspos.dtos.response.CustomerResponse;

public interface ICustomerService {
    CustomerResponse saveCustomer(CustomerRequest customerRequest);

    CustomerResponse editedCustomer(CustomerRequestEdited customerRequestEdited, Long id);

    Boolean deleteCustomer(Long id);
}
