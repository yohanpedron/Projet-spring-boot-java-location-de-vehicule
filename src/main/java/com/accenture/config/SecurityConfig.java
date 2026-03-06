package com.accenture.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.sql.DataSource;

import static org.springframework.boot.security.autoconfigure.web.servlet.PathRequest.toH2Console;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class SecurityConfig {


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
//                .csrf(AbstractHttpConfigurer::disable)

                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers(toH2Console())
                        .disable())
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers(toH2Console()
//                                "/v3/api-docs/**",
//                                "/swagger-ui/**",
//                                "/swagger-ui.html"
                                ).permitAll()
                                .requestMatchers(HttpMethod.GET,"/admins/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT,"/admins/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE,"/admins/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PATCH,"/admins/**").hasRole("ADMIN")

                                .requestMatchers(HttpMethod.GET,"/clients/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT,"/clients/**").hasRole("CLIENT")
                                .requestMatchers(HttpMethod.DELETE,"/clients/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PATCH,"/clients/**").hasRole("ADMIN")

                                .requestMatchers(HttpMethod.GET,"/cars/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT,"/cars/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE,"/cars/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PATCH,"/cars/**").hasRole("ADMIN")

                                .requestMatchers(HttpMethod.GET,"/motorcycles/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT,"/motorcycles/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE,"/motorcycles/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PATCH,"/motorcycles/**").hasRole("ADMIN")

                                .anyRequest().permitAll()
                );
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select mail, password, 1 from connected_user where mail = ?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select mail, role from connected_user where mail = ?");
        return jdbcUserDetailsManager;
    }


    //    @Bean
    UserDetailsManager inMemoryUserDetailsManager() {
        UserDetails user = org.springframework.security.core.userdetails.User
                .withUsername("user")
                .password(passwordEncoder().encode("user"))
                .roles("USER")
                .build();

        UserDetails admin = org.springframework.security.core.userdetails.User
                .withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }



}