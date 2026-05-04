package com.hewhorizon.hrms.saas.repositories;

import com.hewhorizon.hrms.saas.entities.FeatureFlag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeatureFlagRepository extends JpaRepository<FeatureFlag, Long> {
    Optional<FeatureFlag> findByTenantIdAndFeatureKey(Long tenantId, String featureKey);
}
