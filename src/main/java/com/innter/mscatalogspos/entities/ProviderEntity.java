package com.innter.mscatalogspos.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_providers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProviderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fi_id")
    private Long id;

    @Column(name = "fc_company_name")
    private String companyName;

    @Column(name = "fc_commercial_section")
    private String commercialSection;

    @Column(name = "fc_document_type")
    private String documentType;

    @Column(name = "fc_document_number")
    private String documentNumber;

    @Column(name = "fc_address")
    private String address;

    @Column(name = "fc_phone")
    private String phone;

    @Column(name = "fc_email")
    private String email;

    @Column(name = "fc_url")
    private String url;
}

