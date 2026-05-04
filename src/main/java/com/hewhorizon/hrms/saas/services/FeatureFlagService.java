package com.hewhorizon.hrms.saas.services;

import com.hewhorizon.hrms.saas.entities.FeatureFlag;

public interface FeatureFlagService {
    boolean isFeatureEnabled(Long tenantId, String featureKey);
    FeatureFlag upsert(Long tenantId, String key, Boolean enabled);
}
