package com.innter.mscatalogspos.services;

import com.innter.mscatalogspos.dtos.request.PresentationRequest;
import com.innter.mscatalogspos.dtos.request.PresentationRequestEdited;
import com.innter.mscatalogspos.dtos.response.PresentationResponse;

public interface IPresentationService {
    PresentationResponse savePresentation(PresentationRequest presentationRequest);

    PresentationResponse editedPresentation(PresentationRequestEdited presentationRequestEdited, Long id);

    Boolean deletePresentation(Long id);

}
