package com.springland365.springsecuritymfa.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@Profile("email")
public class WebSecurityConfig {

    @Autowired
    EmailMFAAuthenticationFilter  emailMFAAuthenticationFilter ;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http  ) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .mvcMatchers("/email/login").permitAll()
                        .mvcMatchers("/email/signup").permitAll()
                        .mvcMatchers("/email").authenticated()
                        //.anyRequest().authenticated()
                );



        //http.formLogin( ) ;
        http.httpBasic() ;
        http.addFilterAt(emailMFAAuthenticationFilter , BasicAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {


        return authenticationConfiguration.getAuthenticationManager();
    }


}
