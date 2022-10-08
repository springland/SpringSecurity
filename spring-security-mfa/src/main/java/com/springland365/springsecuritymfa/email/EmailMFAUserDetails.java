package com.springland365.springsecuritymfa.email;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class EmailMFAUserDetails implements UserDetails {

    protected String userName ;

    protected String password ;

    protected String email ;

    protected String  code ;
    protected List<? extends GrantedAuthority> authorities ;


    public EmailMFAUserDetails(String userName , String password , String email , List<? extends GrantedAuthority> authorities )
    {
        this.userName = userName ;
        this.password = password ;
        this.email = email ;
        this.authorities = authorities ;

    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName ;
    }

    public String getEmail()
    {
        return this.email ;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true ;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public String getCode()
    {
        return this.code ;
    }

    public void setCode(String code)
    {
        this.code = code ;
    }

}
