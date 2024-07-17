package hu.therealuhlarzoltan.springcloud.gateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    @Bean
    SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(exchanges ->
                        exchanges
                                .pathMatchers("/headerrouting/**").permitAll()
                                .pathMatchers("/actuator/**").permitAll()
                                .pathMatchers("/eureka/**").permitAll()
                                .pathMatchers("/oauth2/**").permitAll()
                                .pathMatchers("/login/**").permitAll()
                                .pathMatchers("/error/**").permitAll()
                                .pathMatchers("/openapi/**").permitAll()
                                .pathMatchers("/webjars/**").permitAll()
                                .pathMatchers("/config/**").permitAll()
                                .anyExchange().authenticated()
                )
                .oauth2ResourceServer(oauth2 ->
                        oauth2.jwt(Customizer.withDefaults())
                );

        return http.build();
    }
}

