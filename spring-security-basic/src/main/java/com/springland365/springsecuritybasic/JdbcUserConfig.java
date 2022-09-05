package com.springland365.springsecuritybasic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@Profile("jdbc-user")
public class JdbcUserConfig {

    @Bean
    public UserDetailsService jdbcUserService(DataSource dataSource)
    {

        return new JdbcUserDetailsManager(dataSource);

    }


}
