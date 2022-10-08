package com.springland365.springsecuritybasic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

@Configuration
@Profile("web-security-adapter")
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin().loginPage("/write");
        http.httpBasic();
        http.logout();
        http.headers().frameOptions().disable();


        http.authorizeRequests()
                .antMatchers("/h2-console/**").permitAll().
                 mvcMatchers("/read").hasAuthority("READ").
                mvcMatchers("/write").hasAuthority("WRITE").
                mvcMatchers("/manager").hasRole("MANAGER").
                anyRequest()
                .authenticated()
                        .and().csrf().ignoringAntMatchers("/h2-console/**") ;



    }

}
