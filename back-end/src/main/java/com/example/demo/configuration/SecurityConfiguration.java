package com.example.demo.configuration;

import com.example.demo.filters.JWTAuthenticationFilter;
import com.example.demo.filters.JWTAuthorizationFilter;
import com.example.demo.service.AuthenticationUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationUserDetailsService authenticationUserDetailService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers("/websocket/**").permitAll() // Websocket No security for testing purposes
                .antMatchers(HttpMethod.POST, AuthenticationConfigConstants.SIGN_UP_URL,"/trips/{tripId}").permitAll() // permit all "/trips" only for testing per
                .antMatchers(HttpMethod.GET, "/vehicles/**").hasAnyAuthority("fleetOwner")
                .antMatchers(HttpMethod.POST, "/vehicles").hasAnyAuthority("fleetOwner")
                .antMatchers(HttpMethod.POST, "/vehicles/assignDriver").hasAnyAuthority( "driver")
                .antMatchers(HttpMethod.GET, "/vehicles/**").hasAnyAuthority("fleetOwner") // strange bug --> look into it further
                .antMatchers(HttpMethod.GET, "/trips/**").hasAnyAuthority("fleetOwner", "driver")
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                // this disables session creation on Spring Security
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationUserDetailService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000")
                        .allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS");
            }
        };
    }

}
