package com.hewhorizon.hrms.saas.features;

import com.hewhorizon.hrms.saas.configs.TenantContext;
import com.hewhorizon.hrms.saas.services.FeatureFlagService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class FeatureInterceptor implements HandlerInterceptor {

    private final FeatureFlagService featureService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod method)) {
            return true;
        }

        RequiresFeature annotation =
                method.getMethodAnnotation(RequiresFeature.class);

        if (annotation == null) {
            return true;
        }

        String featureKey = annotation.value();
        Long tenantId = TenantContext.get();

        if (tenantId == null) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write("Tenant not resolved");
            return false;
        }

        boolean enabled = featureService.isFeatureEnabled(tenantId, featureKey);

        if (!enabled) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.getWriter().write("Feature disabled: " + featureKey);
            return false;
        }

        return true;
    }
}
