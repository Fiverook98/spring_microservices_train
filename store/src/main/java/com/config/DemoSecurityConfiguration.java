package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfiguration {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager userDetails =  new JdbcUserDetailsManager(dataSource);

        //Override della query di spring security per utilizzare tabelle custom al posto di users e authorities
        userDetails.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");
        userDetails.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");

        return userDetails;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/pippo/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/pippo/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/pippo/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/pippo/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/pippo/employees/**").hasRole("ADMIN")
        );


        http.httpBasic(Customizer.withDefaults());


        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
