package com.BancoSaintPatrick.HomeBanking.configurations;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

@EnableWebSecurity
@Configuration
public class WebAuthorization {

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{

        http.authorizeRequests()
                .requestMatchers(HttpMethod.GET,"/web/**","/api/login","/api/logout","/api/usuarios/**","/api/tarjetas/**","/api/transacciones/**").hasAuthority("CLIENT")
                .requestMatchers(HttpMethod.POST,"/api/logout","/api/usuarios/**","/api/tarjetas/**","/api/transacciones/**").hasAnyAuthority("CLIENT")
                .requestMatchers("/h2-console/**").permitAll()
                .anyRequest().permitAll();
                //.anyRequest().denyAll();

        http
                .formLogin(formLogin -> formLogin
                        .usernameParameter("number")
                        .passwordParameter("pin")
                        .loginPage("/api/login")
                        .successHandler((req, res, auth) -> clearAuthenticationAttributes(req))
                        .failureHandler((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                )
                .logout(logout -> logout
                        .logoutUrl("/api/logout")
                        .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
                )
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers.frameOptions(frameOptionsConfig -> frameOptionsConfig.disable()))
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .authenticationEntryPoint((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                );

        return http.build();

    }
    private void clearAuthenticationAttributes(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        if (session != null) {

            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);

        }
    }
}
