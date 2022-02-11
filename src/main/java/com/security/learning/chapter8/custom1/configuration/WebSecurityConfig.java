package com.security.learning.chapter8.custom1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/vc.jpg").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").loginProcessingUrl("/doLogin")
                .permitAll()
                .and()
                .csrf().disable();
    }


    @Bean
    AuthenticationProvider kaptchaAuthenticationProvider() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user1").password("{noop}password").roles("admin").build());

        KaptchaAuthenticationProvider kaptchaAuthenticationProvider = new KaptchaAuthenticationProvider();
        kaptchaAuthenticationProvider.setUserDetailsService(manager);
        return kaptchaAuthenticationProvider;
    }

    // override local AuthenticationManager class
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() {
        return new ProviderManager(kaptchaAuthenticationProvider());
    }
}
