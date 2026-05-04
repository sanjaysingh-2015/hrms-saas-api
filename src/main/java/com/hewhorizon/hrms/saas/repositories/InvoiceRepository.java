package com.hewhorizon.hrms.saas.repositories;

import com.hewhorizon.hrms.saas.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findByTenantId(Long tenantId);
}
