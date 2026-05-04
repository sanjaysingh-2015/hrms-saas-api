package com.hewhorizon.hrms.saas.services.impl;

import com.hewhorizon.hrms.saas.entities.FeatureFlag;
import com.hewhorizon.hrms.saas.repositories.FeatureFlagRepository;
import com.hewhorizon.hrms.saas.services.FeatureFlagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeatureFlagServiceImpl implements FeatureFlagService {
    private final FeatureFlagRepository repo;

    @Override
    public boolean isFeatureEnabled(Long tenantId, String featureKey) {
        return repo.findByTenantIdAndFeatureKey(tenantId, featureKey)
                .map(FeatureFlag::getIsEnabled)
                .orElse(false);
    }

    @Override
    public FeatureFlag upsert(Long tenantId, String key, Boolean enabled) {
        FeatureFlag flag = repo.findByTenantIdAndFeatureKey(tenantId, key)
                .orElse(new FeatureFlag());

        flag.setTenantId(tenantId);
        flag.setFeatureKey(key);
        flag.setIsEnabled(enabled);

        return repo.save(flag);
    }
}
