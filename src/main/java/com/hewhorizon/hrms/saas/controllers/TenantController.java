package com.hewhorizon.hrms.saas.controllers;

import com.hewhorizon.hrms.saas.entities.Tenant;
import com.hewhorizon.hrms.saas.payloads.requests.TenantRequest;
import com.hewhorizon.hrms.saas.services.TenantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Tenant APIs", description = "Tenant operations")
@RestController
@RequestMapping("/api/tenants")
@RequiredArgsConstructor
public class TenantController {

    private final TenantService service;

    @Operation(summary = "Create tenant")
    @PostMapping
    public ResponseEntity<Tenant> create(@RequestBody TenantRequest request) {
        return ResponseEntity.ok(service.createTenant(request));
    }

    @Operation(summary = "Get Tenant Details")
    @GetMapping("/{id}")
    public ResponseEntity<Tenant> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getTenant(id));
    }

    @Operation(summary = "Get All Tenant Details")
    @GetMapping
    public ResponseEntity<List<Tenant>> getAll() {
        return ResponseEntity.ok(service.getTenants());
    }
}
