package com.hewhorizon.hrms.saas.services.impl;

import com.hewhorizon.hrms.saas.entities.Tenant;
import com.hewhorizon.hrms.saas.payloads.requests.TenantRequest;
import com.hewhorizon.hrms.saas.repositories.TenantRepository;
import com.hewhorizon.hrms.saas.services.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TenantServiceImpl implements TenantService {

    private final TenantRepository tenantRepository;

    @Override
    public Tenant createTenant(TenantRequest request) {
        Tenant tenant = new Tenant();
        tenant.setName(request.getName());
        tenant.setDomain(request.getDomain());
        tenant.setCountry(request.getCountry());
        tenant.setCurrency(request.getCurrency());
        tenant.setTimezone(request.getTimezone());

        return tenantRepository.save(tenant);
    }

    @Override
    public Tenant getTenant(Long id) {
        return tenantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tenant not found"));
    }

    @Override
    public List<Tenant> getTenants() {
        return tenantRepository.findAllByStatus("ACTIVE");
    }
}
