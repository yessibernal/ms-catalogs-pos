package com.innter.mscatalogspos.mappers;

import com.innter.mscatalogspos.dtos.request.CustomerRequest;
import com.innter.mscatalogspos.dtos.response.CustomerResponse;
import com.innter.mscatalogspos.entities.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface ICustomerMapper {

    CustomerResponse customerToCustomerResponse(CustomerEntity customer);

    CustomerEntity customerRequestToCustomer(CustomerRequest customerRequest);
}
