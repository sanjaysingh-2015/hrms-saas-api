package com.hewhorizon.hrms.saas.configs;

import com.hewhorizon.hrms.saas.utils.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class TenantContextFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        try {
            Long tenantId = jwtUtil.getTenantId();
            Long userId = jwtUtil.getUserId();

            TenantContext.set(tenantId);
            UserContext.set(userId);

        } catch (Exception ignored) {}

        filterChain.doFilter(request, response);
    }
}
