package com.hewhorizon.hrms.saas.payloads.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TenantResponse {
    private Long id;
    private String name;
    private String domain;
    private String country;
    private String currency;
    private String timezone;
}
