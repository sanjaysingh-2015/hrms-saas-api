package com.hewhorizon.hrms.saas.services.impl;

import com.hewhorizon.hrms.saas.entities.Subscription;
import com.hewhorizon.hrms.saas.repositories.SubscriptionRepository;
import com.hewhorizon.hrms.saas.services.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    @Override
    public Subscription createSubscription(Subscription sub) {
        return subscriptionRepository.save(sub);
    }

    @Override
    public Subscription getByTenant(Long tenantId) {
        return subscriptionRepository.findByTenantId(tenantId)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));
    }
}
