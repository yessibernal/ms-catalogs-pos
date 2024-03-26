package com.innter.mscatalogspos.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tb_customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fi_id")
    private Long id;

    @Column(name = "fc_name")
    private String name;

    @Column(name = "fc_last_name")
    private String lastName;

    @Column(name = "fc_gender")
    private String gender;

    @Column(name = "fd_birth_date")
    private LocalDate birthDate;

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
}
