package com.hewhorizon.hrms.saas.repositories;

import com.hewhorizon.hrms.saas.entities.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {
    List<Tenant> findAllByStatus(String status);
}
