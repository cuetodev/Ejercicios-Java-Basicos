package com.cuetodev.ej3_1.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/h2-console").permitAll()
                .antMatchers(HttpMethod.GET, "/persona").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/addPerson").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/persona").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/persona").hasAnyRole("ADMIN")
                .anyRequest().authenticated();
    }
}
