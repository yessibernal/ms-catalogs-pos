package com.innter.mscatalogspos.services.IMPL;

import com.innter.mscatalogspos.dtos.request.PresentationRequest;
import com.innter.mscatalogspos.dtos.request.PresentationRequestEdited;
import com.innter.mscatalogspos.dtos.response.PresentationResponse;
import com.innter.mscatalogspos.entities.PresentationEntity;
import com.innter.mscatalogspos.exceptions.BadRequestCatalog;
import com.innter.mscatalogspos.exceptions.NotFoundCatalog;
import com.innter.mscatalogspos.mappers.PresentationMapper;
import com.innter.mscatalogspos.repositories.PresentationRepository;
import com.innter.mscatalogspos.services.IPresentationService;
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
public class PresentationService implements IPresentationService {
    @Autowired
    private PresentationMapper presentationMapper;

    @Autowired
    private PresentationRepository presentationRepository;

    @Transactional
    @Override
    public PresentationResponse savePresentation(PresentationRequest presentationRequest) {
        try {
            PresentationEntity presentation = presentationMapper.presentationRequestToPresentation(presentationRequest);
            presentationRepository.save(presentation);
            return presentationMapper.presentationToPresentationResponse(presentation);
        } catch (Exception e) {
            throw new BadRequestCatalog(P_400, HttpStatus.BAD_REQUEST, ERROR_GENERAL_NOT_CREATED);
        }
    }

    @Transactional
    @Override
    public PresentationResponse editedPresentation(PresentationRequestEdited presentationRequestEdited, Long id) {
        PresentationEntity presentation = findPresentationById(presentationRepository.findById(id));
        if (!presentationRepository.findById(id).isEmpty()) {
            presentation.setDescription(presentationRequestEdited.getDescription());
            presentationRepository.save(presentation);
            return presentationMapper.presentationToPresentationResponse(presentation);
        }
        throw new BadRequestCatalog(P_404, HttpStatus.BAD_REQUEST, ERROR_GENERAL_NOT_EDITED);
    }

    @Override
    public Boolean deletePresentation(Long id) {
        try {
            presentationRepository.deleteById(id);
            return Boolean.TRUE;
        } catch (Exception e) {
            throw new BadRequestCatalog(P_404, HttpStatus.BAD_REQUEST, ERROR_GENERAL_NOT_DELETED);
        }
    }

    private PresentationEntity findPresentationById(Optional<PresentationEntity> optionalPresentationEntity) {
        return optionalPresentationEntity.orElseThrow(() -> new NotFoundCatalog(P_404, HttpStatus.NOT_FOUND, ERROR_GENERAL_NOT_FOUND));
    }
}
