package com.hewhorizon.hrms.saas.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "plan", schema = "saas_db")
@Getter
@Setter
public class Plan extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "price_per_user")
    private BigDecimal pricePerUser;

    private String billingCycle;

    @Column(name = "features_json", columnDefinition = "jsonb")
    private String featuresJson;
}