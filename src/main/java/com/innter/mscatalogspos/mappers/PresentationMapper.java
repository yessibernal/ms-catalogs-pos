package com.innter.mscatalogspos.mappers;

import com.innter.mscatalogspos.dtos.request.PresentationRequest;
import com.innter.mscatalogspos.dtos.response.PresentationResponse;
import com.innter.mscatalogspos.entities.PresentationEntity;
import org.springframework.stereotype.Component;

@Component
public class PresentationMapper implements IPresentationMapper {
    @Override
    public PresentationResponse presentationToPresentationResponse(PresentationEntity presentation) {
        PresentationResponse presentationResponse = new PresentationResponse();
        presentationResponse.setId(presentation.getId());
        presentationResponse.setName(presentation.getName());
        presentationResponse.setDescription(presentation.getDescription());
        return presentationResponse;
    }

    @Override
    public PresentationEntity presentationRequestToPresentation(PresentationRequest presentationRequest) {
        PresentationEntity presentation = new PresentationEntity();
        presentation.setName(presentationRequest.getName());
        presentation.setDescription(presentationRequest.getDescription());
        return presentation;
    }
}
