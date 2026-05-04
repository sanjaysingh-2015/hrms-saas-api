package com.hewhorizon.hrms.saas.controllers;

import com.hewhorizon.hrms.saas.services.FeatureFlagService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Features APIs", description = "Features operations")
@RestController
@RequestMapping("/api/features")
@RequiredArgsConstructor
public class FeatureController {

    private final FeatureFlagService service;

    @Operation(summary = "Toggle Feature")
    @PostMapping("/toggle")
    public ResponseEntity<?> toggle(@RequestParam Long tenantId,
                                    @RequestParam String key,
                                    @RequestParam Boolean enabled) {
        return ResponseEntity.ok(service.upsert(tenantId, key, enabled));
    }

    @Operation(summary = "Check Feature")
    @GetMapping("/check")
    public ResponseEntity<Boolean> check(@RequestParam Long tenantId,
                                         @RequestParam String key) {
        return ResponseEntity.ok(service.isFeatureEnabled(tenantId, key));
    }
}
