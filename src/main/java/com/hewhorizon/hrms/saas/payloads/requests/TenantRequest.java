package com.hewhorizon.hrms.saas.payloads.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TenantRequest {
    private String name;
    private String domain;
    private String country;
    private String currency;
    private String timezone;
}
