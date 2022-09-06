package com.springland365.springsecuritybasic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.ldap.DefaultLdapUsernameToDnMapper;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.userdetails.LdapUserDetailsManager;

@Configuration
@Profile("ldap")
public class LDAPUserConfig {

    @Bean
    public UserDetailsService  ldapUserDetailsService()
    {
        LdapContextSource cs = new DefaultSpringSecurityContextSource( "ldap://127.0.0.1:33389/dc=springland365,dc=com");
        cs.afterPropertiesSet();
        LdapUserDetailsManager ldapUserDetailsManager = new LdapUserDetailsManager(cs);

        ldapUserDetailsManager.setUsernameMapper(  new DefaultLdapUsernameToDnMapper("ou=groups", "uid"));

        ldapUserDetailsManager.setGroupSearchBase("ou=groups");

        return ldapUserDetailsManager;

    }
}
