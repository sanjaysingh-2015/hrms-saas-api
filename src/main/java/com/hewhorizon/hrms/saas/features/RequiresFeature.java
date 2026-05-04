package com.hewhorizon.hrms.saas.features;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequiresFeature {
    String value(); // e.g. "PAYROLL", "ATTENDANCE"
}
