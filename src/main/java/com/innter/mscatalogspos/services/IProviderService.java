package com.innter.mscatalogspos.services;

import com.innter.mscatalogspos.dtos.request.ProviderRequest;
import com.innter.mscatalogspos.dtos.request.ProviderRequestEdited;
import com.innter.mscatalogspos.dtos.response.ProviderResponse;

public interface IProviderService {
    ProviderResponse saveProvider(ProviderRequest providerRequest);

    ProviderResponse editedProvider(ProviderRequestEdited providerRequestEdited, Long id);

    Boolean deleteProvider(Long id);
}
