package co.com.udea.api.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class CorsConfig {

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Collections.singletonList("*")); // Permite a todos los orígenes
        config.setAllowedMethods(Arrays.asList("POST", "GET")); // TODO: Check others required methods
        config.setAllowedHeaders(Collections.singletonList(CorsConfiguration.ALL));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        final FilterRegistrationBean<CorsFilter> corsFilter = new FilterRegistrationBean<>(new CorsFilter(source));
        corsFilter.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return corsFilter;
    }
}
