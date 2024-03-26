package com.innter.mscatalogspos.mappers;

import com.innter.mscatalogspos.dtos.request.PresentationRequest;
import com.innter.mscatalogspos.dtos.response.PresentationResponse;
import com.innter.mscatalogspos.entities.PresentationEntity;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface IPresentationMapper {

    PresentationResponse presentationToPresentationResponse(PresentationEntity presentation);

    PresentationEntity presentationRequestToPresentation(PresentationRequest presentationRequest);
}
