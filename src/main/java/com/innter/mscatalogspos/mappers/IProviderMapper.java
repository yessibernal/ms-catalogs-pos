package com.innter.mscatalogspos.mappers;

import com.innter.mscatalogspos.dtos.request.ProviderRequest;
import com.innter.mscatalogspos.dtos.response.ProviderResponse;
import com.innter.mscatalogspos.entities.ProviderEntity;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface IProviderMapper {

    ProviderResponse providerToProviderResponse(ProviderEntity provider);

    ProviderEntity providerRequestToProvider(ProviderRequest providerRequest);
}
