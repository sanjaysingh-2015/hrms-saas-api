package com.hewhorizon.hrms.saas.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "subscription", schema = "saas_db")
@Getter
@Setter
public class Subscription extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tenantId;
    private Long planId;

    private LocalDate startDate;
    private LocalDate endDate;
}