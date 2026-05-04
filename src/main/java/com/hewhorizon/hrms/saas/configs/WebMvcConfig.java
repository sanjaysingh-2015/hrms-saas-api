package com.hewhorizon.hrms.saas.configs;


import com.hewhorizon.hrms.saas.features.FeatureInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final FeatureInterceptor featureInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(featureInterceptor)
                .addPathPatterns("/api/**");
    }
}
