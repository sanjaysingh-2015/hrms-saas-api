package com.hewhorizon.hrms.saas.services;

import com.hewhorizon.hrms.saas.entities.Subscription;

public interface SubscriptionService {
    Subscription createSubscription(Subscription sub);
    Subscription getByTenant(Long tenantId);
}
