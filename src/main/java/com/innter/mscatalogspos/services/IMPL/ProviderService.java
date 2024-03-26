package com.innter.mscatalogspos.services.IMPL;

import com.innter.mscatalogspos.dtos.request.ProviderRequest;
import com.innter.mscatalogspos.dtos.request.ProviderRequestEdited;
import com.innter.mscatalogspos.dtos.response.ProviderResponse;
import com.innter.mscatalogspos.entities.ProviderEntity;
import com.innter.mscatalogspos.exceptions.BadRequestCatalog;
import com.innter.mscatalogspos.exceptions.NotFoundCatalog;
import com.innter.mscatalogspos.mappers.ProviderMapper;
import com.innter.mscatalogspos.repositories.ProviderRepository;
import com.innter.mscatalogspos.services.IProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.innter.mscatalogspos.constants.MassageErrorConstantsCatalogs.*;

@Service
@Slf4j
public class ProviderService implements IProviderService {

    @Autowired
    private ProviderMapper providerMapper;

    @Autowired
    private ProviderRepository providerRepository;

    @Transactional
    @Override
    public ProviderResponse saveProvider(ProviderRequest providerRequest) {
        try {
            ProviderEntity provider = providerMapper.providerRequestToProvider(providerRequest);
            providerRepository.save(provider);
            return providerMapper.providerToProviderResponse(provider);
        } catch (Exception e) {
            throw new BadRequestCatalog(P_400, HttpStatus.BAD_REQUEST, ERROR_GENERAL_NOT_CREATED);
        }
    }

    @Transactional
    @Override
    public ProviderResponse editedProvider(ProviderRequestEdited providerRequestEdited, Long id) {
        ProviderEntity provider = findProviderById(providerRepository.findById(id));
        if (!providerRepository.findById(id).isEmpty()) {
            provider.setDocumentType(providerRequestEdited.getDocumentType());
            provider.setDocumentNumber(providerRequestEdited.getDocumentNumber());
            provider.setAddress(providerRequestEdited.getAddress());
            provider.setPhone(providerRequestEdited.getPhone());
            provider.setEmail(providerRequestEdited.getEmail());
            provider.setUrl(providerRequestEdited.getUrl());
            providerRepository.save(provider);
            return providerMapper.providerToProviderResponse(provider);
        }
        throw new BadRequestCatalog(P_404, HttpStatus.BAD_REQUEST, ERROR_GENERAL_NOT_EDITED);
    }

    @Override
    public Boolean deleteProvider(Long id) {
        try {
            providerRepository.deleteById(id);
            return Boolean.TRUE;
        } catch (Exception e) {
            throw new BadRequestCatalog(P_404, HttpStatus.BAD_REQUEST, ERROR_GENERAL_NOT_DELETED);
        }
    }

    private ProviderEntity findProviderById (Optional<ProviderEntity> optionalProviderEntity){
        return optionalProviderEntity.orElseThrow(()->new NotFoundCatalog(P_404, HttpStatus.NOT_FOUND, ERROR_GENERAL_NOT_FOUND));
    }
}
