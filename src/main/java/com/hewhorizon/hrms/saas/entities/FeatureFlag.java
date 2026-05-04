package com.hewhorizon.hrms.saas.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "feature_flag", schema = "saas_db")
@Getter
@Setter
public class FeatureFlag extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tenantId;
    private String featureKey;
    private Boolean isEnabled;
}
