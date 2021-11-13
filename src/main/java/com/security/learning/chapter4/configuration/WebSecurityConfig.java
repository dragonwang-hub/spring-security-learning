package com.security.learning.chapter4.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/api/**").hasRole("ADMIN")
                .antMatchers("/user/api/**").hasRole("USER")
                .antMatchers("/app/api/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .csrf().disable();
    }

// MemoryUserDetailsManager example
//    @Override
//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
//        inMemoryUserDetailsManager.createUser(User.withUsername("user").password("password").roles("USER").build());
//        inMemoryUserDetailsManager.createUser(User.withUsername("admin").password("password").roles("ADMIN").build());
//        return inMemoryUserDetailsManager;
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    //DataSourceUserDetailsManager example
    @Autowired(required = false)
    private DataSource dataSource;

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
        jdbcUserDetailsManager.setDataSource(dataSource);
        if (!jdbcUserDetailsManager.userExists("user")) {
            jdbcUserDetailsManager.createUser(User.withUsername("user").password("password").roles("USER").build());
        }
        if(!jdbcUserDetailsManager.userExists("admin")) {
            jdbcUserDetailsManager.createUser(User.withUsername("admin").password("password").roles("ADMIN", "USER").build());
        }
        return jdbcUserDetailsManager;
    }
}
