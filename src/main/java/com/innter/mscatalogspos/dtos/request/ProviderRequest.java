package com.innter.mscatalogspos.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProviderRequest {

    @JsonProperty("companyName")
    private String companyName;

    @JsonProperty("commercialSection")
    private String commercialSection;

    @JsonProperty("documentType")
    private String documentType;

    @JsonProperty("documentNumber")
    private String documentNumber;

    @JsonProperty("address")
    private String address;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("email")
    private String email;

    @JsonProperty("url")
    private String url;
}
