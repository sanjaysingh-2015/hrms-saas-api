package com.hewhorizon.hrms.saas.services;

import com.hewhorizon.hrms.saas.entities.Tenant;
import com.hewhorizon.hrms.saas.payloads.requests.TenantRequest;

import java.util.List;

public interface TenantService {
    Tenant createTenant(TenantRequest request);
    Tenant getTenant(Long id);
    List<Tenant> getTenants();
}
