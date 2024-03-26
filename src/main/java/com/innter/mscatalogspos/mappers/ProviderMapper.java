package com.innter.mscatalogspos.mappers;

import com.innter.mscatalogspos.dtos.request.ProviderRequest;
import com.innter.mscatalogspos.dtos.response.ProviderResponse;
import com.innter.mscatalogspos.entities.ProviderEntity;
import org.springframework.stereotype.Component;

@Component
public class ProviderMapper implements IProviderMapper {
    @Override
    public ProviderResponse providerToProviderResponse(ProviderEntity provider) {
        ProviderResponse providerResponse = new ProviderResponse();
        providerResponse.setId(provider.getId());
        providerResponse.setCompanyName(provider.getCompanyName());
        providerResponse.setCommercialSection(provider.getCommercialSection());
        providerResponse.setDocumentType(provider.getDocumentType());
        providerResponse.setDocumentNumber(provider.getDocumentNumber());
        providerResponse.setAddress(provider.getAddress());
        providerResponse.setPhone(provider.getPhone());
        providerResponse.setEmail(provider.getEmail());
        providerResponse.setUrl(provider.getUrl());
        return providerResponse;
    }

    @Override
    public ProviderEntity providerRequestToProvider(ProviderRequest providerRequest) {
        ProviderEntity provider = new ProviderEntity();
        provider.setCompanyName(providerRequest.getCompanyName());
        provider.setCommercialSection(providerRequest.getCommercialSection());
        provider.setDocumentType(providerRequest.getDocumentType());
        provider.setDocumentNumber(providerRequest.getDocumentNumber());
        provider.setAddress(providerRequest.getAddress());
        provider.setPhone(providerRequest.getPhone());
        provider.setEmail(providerRequest.getEmail());
        provider.setUrl(providerRequest.getUrl());
        return provider;
    }
}
